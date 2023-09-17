package pro.sky.telegrambot.service;


import org.springframework.stereotype.Service;



import pro.sky.telegrambot.model.Shelter;

import pro.sky.telegrambot.repository.SheltersRepository;

import java.util.Optional;


@Service
public class SheltersService {

    private final SheltersRepository sheltersRepository;


    public SheltersService(SheltersRepository sheltersRepository) {
        this.sheltersRepository = sheltersRepository;
    }

    public Shelter addShelter(Shelter shelter) {
        return sheltersRepository.save(shelter);
    }

    public Optional<Shelter> findShelterById(Long id) {
        return sheltersRepository.findById(id);
    }

    public Shelter editShelter(Shelter shelter) {
        return sheltersRepository.save(shelter);
    }
     public void deleteShelter(Long id) {
        sheltersRepository.deleteById(id);
    }
}





