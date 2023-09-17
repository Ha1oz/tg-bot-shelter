package pro.sky.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pro.sky.telegrambot.model.Pet;

import java.util.Optional;

public interface PetsRepository extends JpaRepository<Pet, Long> {

//    Optional<Pet> findById(Long id);
    Optional<Pet> findById(String petOfType);

//    Optional<Pet> findPetByType(String petOfType);
//     Optional<Pet> findByType(String petType);
}
