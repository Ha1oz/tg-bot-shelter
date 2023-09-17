package pro.sky.telegrambot.service;

import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.Pet;
import pro.sky.telegrambot.model.Volunteer;
import pro.sky.telegrambot.repository.VolunteersRepository;

import java.util.Optional;

@Service
public class VolunteersService {

    private final VolunteersRepository volunteersRepository;

    public VolunteersService(VolunteersRepository volunteersRepository) {
        this.volunteersRepository = volunteersRepository;
    }


    public Volunteer addVolunteer(Volunteer volunteer) {
        return volunteersRepository.save(volunteer);
    }

    public Optional<Volunteer> findVolunteerById(Long id) {
        return volunteersRepository.findById(id);
    }

    public Volunteer editVolunteer(Volunteer volunteer) {
        return volunteersRepository.save(volunteer);
    }

    public void deleteVolunteer(Long id) {
        volunteersRepository.deleteById(id);
    }
}


