package pro.sky.telegrambot.service;


import org.springframework.stereotype.Service;



import pro.sky.telegrambot.model.Shelter;

import pro.sky.telegrambot.repository.ShelterRepository;

import java.util.Optional;


@Service
public class ShelterService {

    private final ShelterRepository shelterRepository;


    public ShelterService(ShelterRepository shelterRepository) {
        this.shelterRepository = shelterRepository;
    }

    public Shelter addShelter(Shelter shelter) {
        return shelterRepository.save(shelter);
    }

    public Optional<Shelter> findShelterById(Long id) {
        return shelterRepository.findById(id);
    }

    public Shelter editShelter(Shelter shelter) {
        return shelterRepository.save(shelter);
    }
     public void deleteShelter(Long id) {
        shelterRepository.deleteById(id);
    }
}





