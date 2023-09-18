package pro.sky.telegrambot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.Pet;
import pro.sky.telegrambot.model.Volunteer;
import pro.sky.telegrambot.repository.PetRepository;
import pro.sky.telegrambot.repository.VolunteerRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class VolunteerService {
    @Autowired
    private VolunteerRepository volunteerRepository;

    public VolunteerService(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    /**
     * Метод добавляет волонтера в базу данных.
     *
     * @param volunteer
     * @return Volunteer
     */
    public Volunteer addVolunteer(Volunteer volunteer){
        return volunteerRepository.save(volunteer);
    }

    /**
     * Метод выводит весь список волонтеров.
     *
     * @return Collection
     */
    public Collection<Volunteer> getAllVolunteer(){
        return volunteerRepository.findAll();
    }
}
