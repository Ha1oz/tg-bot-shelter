package pro.sky.telegrambot.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import pro.sky.telegrambot.model.Shelter;

/**
 * Репозиторий для работы с сущностью Shelter.
 */
public interface ShelterRepository extends JpaRepository<Shelter, Long> {
}