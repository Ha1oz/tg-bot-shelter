package pro.sky.telegrambot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.telegrambot.model.User;
import pro.sky.telegrambot.model.Volunteer;

public interface VolunteersRepository extends JpaRepository<Volunteer, Long> {
}
