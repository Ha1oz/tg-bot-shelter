package pro.sky.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pro.sky.telegrambot.model.Report;

import java.util.List;

/**
 * Репозиторий для работы с сущностью Report.
 */
@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    /**
     * Возвращает количество отчетов для указанного пользователя.
     *
     * @param chatId идентификатор пользователя
     * @return количество отчетов
     */
    @Query(
            value = "SELECT count(*) " +
                    "FROM reports " +
                    "INNER JOIN users ON users.id = reports.user_id " +
                    "WHERE users.chat_id = :id",
            nativeQuery = true
    )
    Integer getCountFromUser(@Param("id") Long chatId);

    /**
     * Возвращает все отчеты для указанного пользователя.
     *
     * @param chatId идентификатор пользователя
     * @return список отчетов
     */
    @Query(
            value = "SELECT * " +
                    "FROM reports " +
                    "INNER JOIN users ON users.id = reports.user_id " +
                    "WHERE users.chat_id = :id",
            nativeQuery = true
    )
    List<Report> getAllFromUser(@Param("id") Long chatId);
}
