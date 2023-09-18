package pro.sky.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.telegrambot.model.Pet;

public interface PetsRepository extends JpaRepository<Pet, Long> {
}
