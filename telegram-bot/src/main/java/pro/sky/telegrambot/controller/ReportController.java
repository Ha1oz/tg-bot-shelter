package pro.sky.telegrambot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.telegrambot.dto.Mapper;
import pro.sky.telegrambot.error.ReportNotFoundException;
import pro.sky.telegrambot.model.Photo;
import pro.sky.telegrambot.model.Report;
import pro.sky.telegrambot.service.ReportService;

import java.io.IOException;
import java.util.Optional;

/**
 * Контроллер для обработки HTTP-запросов, связанных с питомцами.
 * Включает основные CRUD-запросы.
 */
@RestController
@RequestMapping("/report")
@AllArgsConstructor
public class ReportController {
    private final ReportService reportService;
    private final Mapper mapper;

    /**
     * Обрабатывает GET-запрос для поиска отчёта по идентификатору
     *
     * @param id Идентификатор отчётв.
     * @return ResponseEntity питомца с указанным идентификатором, если найден, в противном случае возвращает 404 ошибку.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Report> findReport(@PathVariable Long id) {
        Optional<Report> reportOptional = reportService.findReport(id);

        if (reportOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(reportOptional.get());
    }
    @PostMapping(value = "/{userId}/data", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> addReport(@PathVariable Long userId, @RequestParam String text, @RequestParam MultipartFile photo)
            throws IOException {
        reportService.uploadReport(userId, text, photo);
        return ResponseEntity.ok().build();
    }
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
}
