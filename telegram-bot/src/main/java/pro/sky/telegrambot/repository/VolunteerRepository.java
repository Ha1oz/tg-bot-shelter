package pro.sky.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pro.sky.telegrambot.model.Volunteer;

import java.util.Optional;

/**
 * Репозиторий для работы с сущностью Volunteer.
 */
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
    Optional<Volunteer> findByChatId(Long id);
    //TODO: something better then emul random Volunteer, temporary solution
    @Query(
            value = "SELECT * " +
                    "FROM volunteers " +
                    "WHERE id IS NOT NULL " +
                    "LIMIT 1",
            nativeQuery = true
    )
    Optional<Volunteer> findFirst();
    Optional<Volunteer> findFirstByIsBusy(boolean bool);
}
