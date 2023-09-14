package pro.sky.telegrambot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.telegrambot.model.User;


public interface UsersRepository extends JpaRepository<User, Long> {
}
