
package pro.sky.telegrambot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.telegrambot.model.Pet;
import pro.sky.telegrambot.service.PetService;

import java.util.Optional;


/**
 * Контроллер для обработки HTTP-запросов, связанных с питомцами.
 * Включает основные CRUD-запросы.
 */
@RestController
@RequestMapping("/pet")
public class PetController {

    private final PetService petService;

    /**
     * Конструктор контроллера, который принимает сервис для работы с питомцами.
     *
     * @param petService Сервис для работы с питомцами.
     */

    public PetController(PetService petService) {
        this.petService = petService;
    }

    /**
     * Обрабатывает POST-запрос для добавления нового питомца.
     *
     * @param pet Переданный питомец в теле запроса.
     * @return Питомец, который был добавлен с помощью сервиса.
     */
    @PostMapping("/add")
    public Pet addPet(@RequestBody Pet pet) {
        Pet addPet = petService.addPet(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(addPet).getBody();
    }

    /**
     * Обрабатывает GET-запрос для поиска питомца по идентификатору.
     *
     * @param id Идентификатор питомца.
     * @return Питомец с указанным идентификатором, если найден, в противном случае возвращает 404 ошибку.
     */
    @GetMapping("{id}")

    public ResponseEntity<Pet> findPetById(@PathVariable Long id) {
        Optional<Pet> pet = petService.findPetById(id);

        if (pet.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(pet.get());
    }

    /**
     * Обрабатывает PUT-зарос для редактирования питомца.
     *
     * @param pet Питомец с обновленными данными в теле запроса.
     * @param id  Идентификатор редактируемого питомца.
     * @return Обновленный питомец, если редактирование выполнено успешно, в противном случаи возвращает 404 ошибку.
     */

    @PutMapping("{id}")
    public ResponseEntity<Pet> editPet(@RequestBody Pet pet, @PathVariable Long id) {
        Pet foundPet = petService.editPet(pet);

        if (foundPet == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(foundPet);
    }

    /**
     * Обрабатывает DELETE-запрос для удаления питомца.
     *
     * @param id Идентификатор питомца для удаления.
     * @return Подтверждение успешного удаления питомца.
     */
    @DeleteMapping("{id}")
    public Pet deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return (Pet) ResponseEntity.status(HttpStatus.OK);
    }

    //TO DO
    // Возможно стоит добавить поиск по типу питомца (выводить только кошек или только собак)
}