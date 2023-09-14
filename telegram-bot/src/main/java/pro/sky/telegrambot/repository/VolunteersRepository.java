package pro.sky.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.telegrambot.model.Volunteer;

public interface VolunteersRepository extends JpaRepository<Volunteer, Long> {
}
