package pro.sky.telegrambot.service;

import org.springframework.stereotype.Service;

import pro.sky.telegrambot.model.Pet;
import pro.sky.telegrambot.repository.PetRepository;

import java.util.Optional;

/**
 * Сервис для управления данными о домашних животных.
 */
@Service
public class PetService {

    private final PetRepository petRepository;

    /**
     * Конструктор сервиса.
     *
     * @param petRepository Репозиторий для доступа к данным о домашних животных.
     */
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    /**
     * Добавляет домашнего животного в базу данных.
     *
     * @param pet Объект домашнего животного для добавления.
     * @return Добавленный объект домашнего животного.
     */
    public Pet addPet(Pet pet) {
        return petRepository.save(pet);
    }

    /**
     * Ищет домашнее животное по его идентификатору.
     *
     * @param id Идентификатор домашнего животного.
     * @return Optional с объектом домашнего животного, если найден, иначе пустой Optional.
     */
    public Optional<Pet> findPetById(Long id) {
        return petRepository.findById(id);
    }

    /**
     * Редактирует информацию о домашнем животном.
     *
     * @param pet Объект домашнего животного с обновленными данными.
     * @return Обновленный объект домашнего животного.
     */
    public Pet editPet(Pet pet) {
        return petRepository.save(pet);
    }

    /**
     * Удаляет домашнее животное из базы данных.
     *
     * @param id Идентификатор домашнего животного для удаления.
     */
    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }

    /**
     * Ищет домашнее животное по его виду или типу.
     *
     * @param petOfType Вид или тип домашнего животного для поиска.
     * @return Optional с объектом домашнего животного, если найден, иначе пустой Optional.
     */
    public Optional<Pet> findPetByType(String petOfType) {
        return petRepository.findByPetType(petOfType);
    }

 }
