package pro.sky.telegrambot.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import pro.sky.telegrambot.model.Pet;
import pro.sky.telegrambot.model.Shelter;

import java.util.Optional;

public interface SheltersRepository extends JpaRepository<Shelter, Long> {



}