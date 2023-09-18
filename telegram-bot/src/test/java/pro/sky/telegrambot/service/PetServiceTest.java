package pro.sky.telegrambot.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pro.sky.telegrambot.model.Pet;
import pro.sky.telegrambot.repository.PetsRepository;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PetServiceTest {

    @Mock
    private PetsRepository petsRepository;

    private final PetService petService;

    public PetServiceTest() {
        MockitoAnnotations.openMocks(this);
        petService = new PetService(petsRepository);
    }

    @Test
    public void testAddPet() {
        Pet pet = new Pet();
        pet.setName("Вася");

        when(petsRepository.save(any(Pet.class))).thenReturn(pet);

        Pet addedPet = petService.addPet(pet);

        assertEquals("Вася", addedPet.getName());

        verify(petsRepository, times(1)).save(any(Pet.class));
    }

    @Test
    public void testFindPetById() {
        Pet pet = new Pet();
        pet.setId(1L);
        pet.setName("Вася");

        when(petsRepository.findById(1L)).thenReturn(Optional.of(pet));

        Optional<Pet> foundPet = petService.findPetById(1L);

        assertEquals("Вася", foundPet.get().getName());

        verify(petsRepository, times(1)).findById(1L);
    }

    @Test
    public void testEditPet() {
        Pet pet = new Pet();
        pet.setId(1L);
        pet.setName("Вася");

        when(petsRepository.save(any(Pet.class))).thenReturn(pet);

        Pet editedPet = petService.editPet(pet);

        assertEquals("Вася", editedPet.getName());

        verify(petsRepository, times(1)).save(any(Pet.class));
    }

    @Test
    public void testDeletePet() {
        petService.deletePet(1L);

        verify(petsRepository, times(1)).deleteById(1L);
    }
}