package pro.sky.telegrambot.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.InputStreamSource;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.telegrambot.model.Pet;
import pro.sky.telegrambot.model.Photo;
import pro.sky.telegrambot.model.Report;
import pro.sky.telegrambot.model.User;
import pro.sky.telegrambot.repository.PhotoRepository;
import pro.sky.telegrambot.repository.ReportRepository;
import pro.sky.telegrambot.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReportServiceTest {
    private ReportService reportService;
    private Report report;
    private Photo photo;
    private User user;
    @Mock
    private UserRepository userRepositoryMock;
    @Mock
    private ReportRepository reportRepositoryMock;
    @Mock
    private PhotoRepository photoRepositoryMock;

    @BeforeEach
    void setUp() {
        reportService = new ReportService(reportRepositoryMock, userRepositoryMock, photoRepositoryMock);

        photo = new Photo();
        photo.setFileSize(-1);

        user = new User();
        user.setName("test");
        user.setChatId(100L);

        report = new Report();
        report.setId(1L);
        report.setText("text");
    }

    @Test
    void addReport() {
        when(reportRepositoryMock.save(any(Report.class))).thenReturn(report);

        Report addedReport = reportService.addReport(report);

        assertEquals("text", addedReport.getText());

        verify(reportRepositoryMock, times(1)).save(any(Report.class));
    }

    @Test
    void uploadReport() {
        when(reportRepositoryMock.save(any(Report.class))).thenReturn(report);
        when(userRepositoryMock.findByChatId(any(Long.class))).thenReturn(Optional.of(user));
        when(photoRepositoryMock.save(any(Photo.class))).thenReturn(photo);
        when(reportRepositoryMock.getCountFromUser(any(Long.class))).thenReturn(1);
        // TODO: should continue testing
    }

    @Test
    void findReport() {
        when(reportRepositoryMock.findById(1L)).thenReturn(Optional.of(report));

        Optional<Report> foundReport = reportService.findReport(1L);

        assertEquals("text", foundReport.get().getText());

        verify(reportRepositoryMock, times(1)).findById(1L);
    }

    @Test
    void deleteById() {
        reportService.deleteReport(1L);

        verify(reportRepositoryMock, times(1)).deleteById(1L);
    }

    @Test
    void getReportCountFromUser() {
        when(reportRepositoryMock.getCountFromUser(any(Long.class))).thenReturn(1);

        Integer count = reportService.getReportCountFromUser(user.getChatId());

        assertEquals(1, count);

        verify(reportRepositoryMock, times(1)).getCountFromUser(user.getChatId());
    }

    @Test
    void getAllReportsByOneUser() {
        List<Report> res = List.of(report);

        when(reportRepositoryMock.getAllFromUser(any(Long.class))).thenReturn(res);

        List<Report> reports = reportService.getAllReportsByOneUser(user.getChatId());

        assertEquals(res, reports);

        verify(reportRepositoryMock, times(1)).getAllFromUser(user.getChatId());
    }
}