package pro.sky.telegrambot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.error.VolunteerNotFoundException;
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
    public Optional<Volunteer> findVolunteerById(Long id) {
        return volunteerRepository.findById(id);
    }
    public Optional<Volunteer> findVolunteerByChatId(Long chatId) {
        return volunteerRepository.findByChatId(chatId);
    }
    public Optional<Volunteer> findFreeVolunteer() {
        return volunteerRepository.findFirstByIsBusy(false);
    }
    public Volunteer keepVolunteerBusy(Long chatId, Boolean isBusy) {
        Optional<Volunteer> volunteerOptional = findVolunteerByChatId(chatId);
        if (volunteerOptional.isEmpty()) {
            throw new VolunteerNotFoundException();
        }
        Volunteer volunteer = volunteerOptional.get();
        volunteer.setBusy(isBusy);

        return editVolunteer(volunteer);
    }

    public Volunteer editVolunteer(Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }

    public void deleteVolunteer(Long id) {
        volunteerRepository.deleteById(id);
    }
}
