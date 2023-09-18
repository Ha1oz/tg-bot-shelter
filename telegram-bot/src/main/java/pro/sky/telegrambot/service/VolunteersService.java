package pro.sky.telegrambot.service;

import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.Pet;
import pro.sky.telegrambot.model.Volunteer;
import pro.sky.telegrambot.repository.VolunteerRepository;

import java.util.Optional;

@Service
public class VolunteersService {

    private final VolunteerRepository volunteerRepository;

    public VolunteersService(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }


    public Volunteer addVolunteer(Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }

    public Optional<Volunteer> findVolunteerById(Long id) {
        return volunteerRepository.findById(id);
    }

    public Volunteer editVolunteer(Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }

    public void deleteVolunteer(Long id) {
        volunteerRepository.deleteById(id);
    }
}


