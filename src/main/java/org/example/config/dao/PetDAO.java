package org.example.config.dao;

import org.example.config.models.Pet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PetDAO {
    private static int PET_COUNT;
    private List<Pet> pets;

    {
        pets = new ArrayList<>();
        pets.add(new Pet(++PET_COUNT, "Dog", "Lucky"));
        pets.add(new Pet(++PET_COUNT, "Dog", "Bad Boy"));
        pets.add(new Pet(++PET_COUNT, "Cat", "Potato"));
        pets.add(new Pet(++PET_COUNT, "Mouse", "Jerry"));
        pets.add(new Pet(++PET_COUNT, "Bearded Dragon", "Abraham"));

    }

    public List<Pet> index() {
        return pets;
    }

    public Pet showById(int id) {
        Pet pet = null;
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getId() == id) {
                pet = pets.get(i);
            }
        } return pet;
    }

    public void save(Pet pet){
        pet.setId(++PET_COUNT);
        pets.add(pet);
    }
}


