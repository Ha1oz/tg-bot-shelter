package pro.sky.telegrambot.service;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pro.sky.telegrambot.model.User;

import pro.sky.telegrambot.repository.UsersRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UsersServiceTest {

    @Mock
    private UsersRepository usersRepository;

    private final UsersService usersService;

    public UsersServiceTest() {
        MockitoAnnotations.openMocks(this);
        usersService = new UsersService(usersRepository);
    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setName("Иванов Иван");

        when(usersRepository.save(any(User.class))).thenReturn(user);

        User addedUser = usersService.addUser(user);

        assertEquals("Иванов Иван", addedUser.getName());

        verify(usersRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testFindUserById() {
        User user = new User();
        user.setChatId(165L);
        user.setName("Николай Иванов");

        when(usersRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<User> foundUser = usersService.findUserById(1L);

        assertEquals("Николай Иванов", foundUser.get().getName());

        verify(usersRepository, times(1)).findById(1L);
    }

    @Test
    public void testEditUser() {
        User user = new User();
        user.setChatId(1L);
        user.setName("Николай Иванов");

        when(usersRepository.save(any(User.class))).thenReturn(user);

        User editedUser = usersService.editUser(user);

        assertEquals("Николай Иванов", editedUser.getName());

        verify(usersRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testDeleteUser() {
        usersService.deleteUser(1L);

        verify(usersRepository, times(1)).deleteById(1L);
    }
}

