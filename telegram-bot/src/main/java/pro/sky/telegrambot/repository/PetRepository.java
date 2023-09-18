package pro.sky.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.telegrambot.model.Pet;

import java.util.Optional;

/**
 * Репозиторий для работы с сущностью Pet.
 */
public interface PetRepository extends JpaRepository<Pet, Long> {

    /**
     * Находит питомца по указанному типу.
     *
     * @param type тип питомца
     * @return объект Optional с найденным питомцем или пустым значением, если питомец не найден
     */
    Optional<Pet> findByPetType(String type);
}
