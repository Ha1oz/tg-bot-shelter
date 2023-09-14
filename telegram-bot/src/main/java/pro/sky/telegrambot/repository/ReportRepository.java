package pro.sky.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.telegrambot.model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
}
