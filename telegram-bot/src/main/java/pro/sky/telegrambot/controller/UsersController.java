package pro.sky.telegrambot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.telegrambot.error.UserNotFoundException;
import pro.sky.telegrambot.model.User;
import pro.sky.telegrambot.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        Optional<User> userOptional = userService.findUser(id);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException();
        }
        return ResponseEntity.ok().body(userOptional.get());
    }
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.addUser(user));
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok().body(userService.updateUser(user));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
