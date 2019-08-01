package com.example.demo.services;

import com.example.demo.entities.Breed;
import com.example.demo.entities.Dog;
import com.example.demo.repositories.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {
    private DogRepository dogRepository;
    private BreedService breedService;
    @Autowired
    public DogService(DogRepository dogRepository, BreedService breedService) {
        this.dogRepository = dogRepository;
        this.breedService = breedService;
    }

    public List<Dog> getDogs() {
        return dogRepository.findAll();
    }

    public Dog createNewDog(Integer breedId, String dogName, String dogGender, int dogAge, boolean isDogSterilized) {
        Breed dogBreed = breedService.getBreedById(breedId);

        Dog newDog = Dog.builder()
                .name(dogName)
                .gender(dogGender)
                .age(dogAge)
                .sterilized(isDogSterilized)
                .breed(dogBreed)
                .build();

        int breedQuantity = dogBreed.getQuantity();
        dogBreed.setQuantity(++breedQuantity);
        breedService.updateBreed(dogBreed);

        dogRepository.save(newDog);
        return newDog;
    }
}
