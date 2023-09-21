package pro.sky.telegrambot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.telegrambot.error.ReportNotFoundException;
import pro.sky.telegrambot.model.Photo;
import pro.sky.telegrambot.model.Report;
import pro.sky.telegrambot.service.ReportService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Контроллер для обработки HTTP-запросов, связанных с отчётами
 * Включает основные CRUD-запросы
 */
@RestController
@RequestMapping("/report")
@AllArgsConstructor
public class ReportController {
    private final ReportService reportService;

    /**
     * Обрабатывает GET-запрос для поиска отчёта по идентификатору
     *
     * @param id Идентификатор отчёта
     * @return ResponseEntity отчёта с указанным идентификатором, если найден, в противном случае возвращает 404 ошибку
     */
    @GetMapping("/{id}")
    public ResponseEntity<Report> findReport(@PathVariable Long id) {
        Optional<Report> reportOptional = reportService.findReport(id);

        if (reportOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(reportOptional.get());
    }
    /**
     * Обрабатывает POST-запрос для добавления нового питомца
     *
     * @param userId Переданный id пользователя
     * @param text Текст отчёта
     * @param photo Изображение отчёта
     * @return ResponseEntity с результатом выполненного запроса
     */
    @PostMapping(value = "/{userId}/data", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> addReport(@PathVariable Long userId, @RequestParam String text, @RequestParam MultipartFile photo)
            throws IOException {
        reportService.uploadReport(userId, text, photo);
        return ResponseEntity.ok().build();
    }
    /**
     * Обрабатывает GET-запрос для выгрузки отчёта по идентификатору
     *
     * @param id Идентификатор отчёта
     * @return ResponseEntity отчёта в байтовом виде с указанным идентификатором, если найден, в противном случае возвращает 404 ошибку
     */
    @GetMapping(value = "/{id}/photo")
    public ResponseEntity<byte[]> downloadAvatar(@PathVariable Long id) {
        Optional<Report> reportOptional = reportService.findReport(id);
        if (reportOptional.isEmpty()) {
            throw new ReportNotFoundException();
        }

        Report report = reportOptional.get();
        Photo photo = report.getPhoto();
        if (photo.getFileSize() == 0) {
            throw new ReportNotFoundException();
        }
        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType(photo.getMediaType()))
                .body(photo.getData());
    }
    /**
     * Обрабатывает GET-запрос для получения всех отчётов по идентификатору пользователя
     *
     * @param userId Переданный id пользователя
     * @return ResponseEntity отчётов ввиде списка
     */
    @GetMapping("/{userId}/all-from-user")
    public ResponseEntity<List<Report>> getAllReportsFromOneUser(@PathVariable Long userId) {
        List<Report> reportList = reportService.getAllReportsByOneUser(userId);
        return ResponseEntity.ok().body(reportList);
    }
    /**
     * Обрабатывает GET-запрос для получения количества отчётов переданных пользователем ранее
     *
     * @param userId Переданный id пользователя
     * @return ResponseEntity количества отчётов
     */
    @GetMapping("/{userId}/count-from-user")
    public ResponseEntity<Integer> getReportCountFromOneUser(@PathVariable Long userId) {
        Integer countFromUser = reportService.getReportCountFromUser(userId);
        return ResponseEntity.ok().body(countFromUser);
    }

}
