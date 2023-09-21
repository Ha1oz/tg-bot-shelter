package pro.sky.telegrambot.service;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pro.sky.telegrambot.model.Shelter;
import pro.sky.telegrambot.repository.ShelterRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ShelterServiceTest {

    @Mock
    private ShelterRepository shelterRepository;

    private final ShelterService shelterService;

    public ShelterServiceTest() {
        MockitoAnnotations.openMocks(this);
        shelterService = new ShelterService(shelterRepository);
    }

    @Test
    public void testAddShelter() {
        Shelter shelter = new Shelter();
        shelter.setId(1L);
        shelter.setDescriptionOfCatShelter("Puffy cats");

        when(shelterRepository.save(any(Shelter.class))).thenReturn(shelter);

        Shelter addedShelter = shelterService.addShelter(shelter);

        assertEquals("Puffy cats", addedShelter.getDescriptionOfCatShelter());

        verify(shelterRepository, times(1)).save(any(Shelter.class));
    }

    @Test
    public void testFindShelterById() {
        Shelter shelter = new Shelter();
        shelter.setId(1L);
        shelter.setDescriptionOfDogShelter("Puffy dogs");

        when(shelterRepository.findById(1L)).thenReturn(Optional.of(shelter));

        Optional<Shelter> foundShelter = shelterService.findShelterById(1L);

        assertEquals("Puffy dogs", foundShelter.get().getDescriptionOfDogShelter());

        verify(shelterRepository, times(1)).findById(1L);
    }

    @Test
    public void testEditPet() {
        Shelter shelter = new Shelter();
        shelter.setId(1L);
        shelter.setDescriptionOfDogShelter("Puffy dogs");

        when(shelterRepository.save(any(Shelter.class))).thenReturn(shelter);

        Shelter editedShelter = shelterService.editShelter(shelter);

        assertEquals("Puffy dogs", editedShelter.getDescriptionOfDogShelter());

        verify(shelterRepository, times(1)).save(any(Shelter.class));
    }

    @Test
    public void testDeleteShelter() {
        shelterService.deleteShelter(1L);

        verify(shelterRepository, times(1)).deleteById(1L);
    }
}