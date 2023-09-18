package pro.sky.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.telegrambot.model.Photo;

/**
 * Репозиторий для работы с сущностью Photo.
 */
@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
