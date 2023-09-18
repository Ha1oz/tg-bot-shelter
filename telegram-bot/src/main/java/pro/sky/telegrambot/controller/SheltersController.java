package pro.sky.telegrambot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.telegrambot.model.Shelter;
import pro.sky.telegrambot.service.ShelterService;

import java.util.Optional;


/**
 * Контроллер для обработки HTTP-запросов, связанных с приютами.
 * Включает основные CRUD-запросы.
 */
@RestController
@RequestMapping("/shelters")
public class SheltersController {

    private final ShelterService shelterService;

    public SheltersController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    /**
     * Конструктор контроллера, который принимает сервис для работы с приютами.
     *
     * @param sheltersService Сервис для работы с приютами.
     */


    /**
     * Обрабатывает POST-запрос для добавления нового приюта.
     *
     * @param shelter Переданный приют  в теле запроса.
     * @return приют, который был добавлен с помощью сервиса.
     */
    @PostMapping("/add")
    public Shelter addShelter(@RequestBody Shelter shelter) {
        Shelter addShelter = shelterService.addShelter(shelter);
        return ResponseEntity.status(HttpStatus.CREATED).body(addShelter).getBody();
    }

    /**
     * Обрабатывает GET-запрос для поиска приюта  по идентификатору.
     *
     * @param id Идентификатор приюта.
     * @return приют  с указанным идентификатором, если найден, в противном случае возвращает 404 ошибку.
     */
    @GetMapping("{id}")
    public Shelter findShelterById(@PathVariable Long id) {
        Optional<Shelter>  shelter = shelterService.findShelterById(id);

        if (shelter.isEmpty()) {
            return (Shelter) ResponseEntity.status(HttpStatus.NOT_FOUND).build().getBody();
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(findShelterById(id)).getBody();
    }

    /**
     * Обрабатывает PUT-зарос для редактирования приюта.
     *
     * @param shelter приют  с обновленными данными в теле запроса.
     * @param id  Идентификатор редактируемого приюта.
     * @return Обновленный приют , если редактирование выполнено успешно, в противном случае возвращает 404 ошибку.
     */
    @PutMapping("{id}")
    public Shelter editShelter(@RequestBody Shelter shelter, @PathVariable Long id) {
        Shelter foundShelter = shelterService.editShelter(shelter);

        if (foundShelter == null) {
            return (Shelter) ResponseEntity.status(HttpStatus.NOT_FOUND).build().getBody();
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(findShelterById(id)).getBody();
    }

    /**
     * Обрабатывает DELETE-запрос для удаления приюта.
     *
     * @param id Идентификатор приюта для удаления.
     * @return Подтверждение успешного удаления приюта.
     */
    @DeleteMapping("{id}")
    public Shelter deleteShelter(@PathVariable Long id) {
        shelterService.deleteShelter(id);
        return (Shelter) ResponseEntity.status(HttpStatus.OK);
    }
}



