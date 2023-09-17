package pro.sky.telegrambot.service;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import pro.sky.telegrambot.model.Volunteer;
import pro.sky.telegrambot.repository.VolunteersRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class VolunteersServiceTest {

    @Mock
    private VolunteersRepository volunteersRepository;

    private final VolunteersService  volunteersService;

    public VolunteersServiceTest() {
        MockitoAnnotations.openMocks(this);
        volunteersService   = new VolunteersService (volunteersRepository);
    }



    @Test
    public void testAddVolunteer() {
        Volunteer volunteer = new Volunteer();
        volunteer.setName("Николаев Петр Иванович");

        when(volunteersRepository.save(any(Volunteer.class))).thenReturn(volunteer);

        Volunteer addedVolunteer = volunteersService.addVolunteer(volunteer);

        assertEquals("Николаев Петр Иванович", addedVolunteer.getName());

        verify( volunteersRepository, times(1)).save(any(Volunteer.class));
    }

    @Test
    public void testFindVolunteerById() {
        Volunteer volunteer = new Volunteer();
        volunteer.setId(1L);
        volunteer.setName("Николаев Петр Иванович");

        when(volunteersRepository.findById(1L)).thenReturn(Optional.of(volunteer));

        Optional<Volunteer> foundVolunteer = volunteersService.findVolunteerById(1L);

        assertEquals("Николаев Петр Иванович", foundVolunteer.get().getName());

        verify(volunteersRepository, times(1)).findById(1L);
    }

    @Test
    public void testEditVolunteer() {
        Volunteer volunteer = new Volunteer();
        volunteer.setId(1L);
        volunteer.setName("Николаев Петр Иванович");

        when(volunteersRepository.save(any(Volunteer.class))).thenReturn(volunteer);

        Volunteer editedVolunteer = volunteersService.editVolunteer(volunteer);

        assertEquals("Николаев Петр Иванович", editedVolunteer.getName());

        verify(volunteersRepository, times(1)).save(any(Volunteer.class));
    }

    @Test
    public void testDeleteVolunteer() {
        volunteersService.deleteVolunteer(1L);

        verify(volunteersRepository, times(1)).deleteById(1L);
    }
}