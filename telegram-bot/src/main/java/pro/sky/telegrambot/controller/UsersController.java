package pro.sky.telegrambot.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.telegrambot.model.Pet;
import pro.sky.telegrambot.model.User;
import pro.sky.telegrambot.service.UsersService;

import java.util.Optional;


/**
 * Контроллер для обработки HTTP-запросов, связанных с питомцами.
 * Включает основные CRUD-запросы.
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;


    /**
     * Конструктор контроллера, который принимает сервис для работы с пользователями.
     *
     * @param usersService Сервис для работы с пользователями.
     */
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    /**
     * Обрабатывает POST-запрос для добавления нового пользователя.
     *
     * @param user Переданный пользователь в теле запроса.
     * @return Пользователь, который был добавлен с помощью сервиса.
     */
    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        User addUser = usersService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(addUser).getBody();
    }

    /**
     * Обрабатывает GET-запрос для поиска пользователя по идентификатору.
     *
     * @param id Идентификатор пользователя.
     * @return Пользователь с указанным идентификатором, если найден, в противном случае возвращает 404 ошибку.
     */
    @GetMapping("{id}")
    public User findUserById(@PathVariable Long id) {
        Optional<User> user = usersService.findUserById(id);

        if (user.isEmpty()) {
            return (User) ResponseEntity.status(HttpStatus.NOT_FOUND).build().getBody();
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(findUserById(id)).getBody();
    }

    /**
     * Обрабатывает PUT-зарос для редактирования пользователя.
     *
     * @param user Пользователь с обновленными данными в теле запроса.
     * @param id  Идентификатор редактируемого пользователя.
     * @return Обновленный пользователь, если редактирование выполнено успешно, в противном случаи возвращает 404 ошибку.
     */
    @PutMapping("{id}")
    public User editUser(@RequestBody User user, @PathVariable Long id) {
        User foundUser = usersService.editUser(user);

        if (foundUser == null) {
            return (User) ResponseEntity.status(HttpStatus.NOT_FOUND).build().getBody();
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(findUserById(id)).getBody();
    }

    /**
     * Обрабатывает DELETE-запрос для удаления пользователя.
     *
     * @param id Идентификатор пользователя для удаления.
     * @return Подтверждение успешного удаления пользователя.
     */
    @DeleteMapping("{id}")
    public User deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
        return (User) ResponseEntity.status(HttpStatus.OK);
    }
}


