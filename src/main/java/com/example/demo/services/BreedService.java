package com.example.demo.services;

import com.example.demo.entities.Breed;
import com.example.demo.exceptions.NoEntityFoundException;
import com.example.demo.repositories.BreedRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BreedService {
    private BreedRepository breedRepository;

    public BreedService(BreedRepository breedRepository) {
        this.breedRepository = breedRepository;
    }

    public List<Breed> getBreeds() {
        return breedRepository.findAll();
    }

    public Breed createNewBreed(String breedName, int breedQuantity) {
        Breed createdBreed = Breed.builder()
                .breedName(breedName)
                .quantity(breedQuantity)
                .build();

        breedRepository.save(createdBreed);
        return createdBreed;
    }

    public Breed getBreedById(Integer breedId) {
        Optional<Breed> breed = breedRepository.findById(breedId);

        if (breed.isPresent()) {
            return breed.get();
        } else {
            throw new NoEntityFoundException(Breed.class, breedId);
        }
    }

    public void updateBreed(Breed updatedDogBreed) {
        breedRepository.save(updatedDogBreed);
    }
}
