package pro.sky.telegrambot.service;

import org.springframework.stereotype.Service;

import pro.sky.telegrambot.model.Pet;
import pro.sky.telegrambot.repository.PetsRepository;

import java.util.Optional;

@Service
public class PetsService {

    private final PetsRepository petsRepository;

    public PetsService(PetsRepository petsRepository) {
        this.petsRepository = petsRepository;
    }


    public Pet addPet(Pet pet) {
        return petsRepository.save(pet);
    }

    public Optional<Pet> findPetById(Long id) {
        return petsRepository.findById(id);
    }

    public Pet editPet(Pet pet) {
        return petsRepository.save(pet);
    }

    public void deletePet(Long id) {
        petsRepository.deleteById(id);
    }

    public Optional<Pet> findPetByType(String petOfType) {
        return petsRepository.findById(petOfType);
    }

 }
