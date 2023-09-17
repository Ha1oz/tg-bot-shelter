package pro.sky.telegrambot.service;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pro.sky.telegrambot.model.Shelter;
import pro.sky.telegrambot.repository.SheltersRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SheltersServiceTest {

    @Mock
    private SheltersRepository sheltersRepository;

    private final SheltersService sheltersService;

    public SheltersServiceTest() {
        MockitoAnnotations.openMocks(this);
        sheltersService = new SheltersService(sheltersRepository);
    }

    @Test
    public void testAddShelter() {
        Shelter shelter = new Shelter();
        shelter.setId(1L);
        shelter.setDescriptionOfCatShelter("Puffy cats");

        when(sheltersRepository.save(any(Shelter.class))).thenReturn(shelter);

        Shelter addedShelter = sheltersService.addShelter(shelter);

        assertEquals("Puffy cats", addedShelter.getDescriptionOfCatShelter());

        verify(sheltersRepository, times(1)).save(any(Shelter.class));
    }

    @Test
    public void testFindShelterById() {
        Shelter shelter = new Shelter();
        shelter.setId(1L);
        shelter.setDescriptionOfDogShelter("Puffy dogs");

        when(sheltersRepository.findById(1L)).thenReturn(Optional.of(shelter));

        Optional<Shelter> foundShelter = sheltersService.findShelterById(1L);

        assertEquals("Puffy dogs", foundShelter.get().getDescriptionOfDogShelter());

        verify(sheltersRepository, times(1)).findById(1L);
    }

    @Test
    public void testEditPet() {
        Shelter shelter = new Shelter();
        shelter.setId(1L);
        shelter.setDescriptionOfDogShelter("Puffy dogs");

        when(sheltersRepository.save(any(Shelter.class))).thenReturn(shelter);

        Shelter editedShelter = sheltersService.editShelter(shelter);

        assertEquals("Puffy dogs", editedShelter.getDescriptionOfDogShelter());

        verify(sheltersRepository, times(1)).save(any(Shelter.class));
    }

    @Test
    public void testDeleteShelter() {
        sheltersService.deleteShelter(1L);

        verify(sheltersRepository, times(1)).deleteById(1L);
    }
}