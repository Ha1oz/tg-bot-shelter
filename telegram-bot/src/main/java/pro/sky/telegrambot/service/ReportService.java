package pro.sky.telegrambot.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.telegrambot.error.ReportNotFoundException;
import pro.sky.telegrambot.model.Pet;
import pro.sky.telegrambot.model.Photo;
import pro.sky.telegrambot.model.Report;
import pro.sky.telegrambot.model.User;
import pro.sky.telegrambot.repository.PhotoRepository;
import pro.sky.telegrambot.repository.ReportRepository;
import pro.sky.telegrambot.repository.UsersRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
@AllArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;
    private final UsersRepository usersRepository;
    private final PhotoRepository photoRepository;

    public Report addReport(Report report) {
        return reportRepository.save(report);
    }
    public void uploadReport(Long userId, String text, MultipartFile reportFile) throws IOException {

        Optional<User> userOptional = usersRepository.findById(userId);

        if (userOptional.isEmpty()) {
            throw new ReportNotFoundException();
        }
        User user = userOptional.get();


        Photo photo = new Photo();
        photo.setData(reportFile.getBytes());
        photo.setFileSize(reportFile.getSize());
        photo.setMediaType(reportFile.getContentType());

        photoRepository.save(photo);

        Report report = new Report();
        report.setUser(user);
        report.setText(text);
        report.setPhoto(photo);

        reportRepository.save(report);
    }
    public Optional<Report> findReport(long id) {
        return reportRepository.findById(id);
    }
    // TO DO: find by user full name
    public void deleteById(long id) {
        reportRepository.deleteById(id);
    }
    private String getExtensions(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}
