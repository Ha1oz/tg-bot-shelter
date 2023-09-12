package pro.sky.telegrambot.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pro.sky.telegrambot.model.Pet;
import pro.sky.telegrambot.repositories.PetsRepository;
import pro.sky.telegrambot.service.PetsService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PetsServiceTest {

    @Mock
    private PetsRepository petsRepository;

    private PetsService petsService;

    public PetsServiceTest() {
        MockitoAnnotations.openMocks(this);
        petsService = new PetsService(petsRepository);
    }

    @Test
    public void testAddPet() {
        Pet pet = new Pet();
        pet.setName("Вася");

        when(petsRepository.save(any(Pet.class))).thenReturn(pet);

        Pet addedPet = petsService.addPet(pet);

        assertEquals("Вася", addedPet.getName());

        verify(petsRepository, times(1)).save(any(Pet.class));
    }

    @Test
    public void testFindPetById() {
        Pet pet = new Pet();
        pet.setId(1L);
        pet.setName("Вася");

        when(petsRepository.findById(1L)).thenReturn(Optional.of(pet));

        Optional<Pet> foundPet = petsService.findPetById(1L);

        assertEquals("Вася", foundPet.get().getName());

        verify(petsRepository, times(1)).findById(1L);
    }

    @Test
    public void testEditPet() {
        Pet pet = new Pet();
        pet.setId(1L);
        pet.setName("Вася");

        when(petsRepository.save(any(Pet.class))).thenReturn(pet);

        Pet editedPet = petsService.editPet(pet);

        assertEquals("Вася", editedPet.getName());

        verify(petsRepository, times(1)).save(any(Pet.class));
    }

    @Test
    public void testDeletePet() {
        petsService.deletePet(1L);

        verify(petsRepository, times(1)).deleteById(1L);
    }
}