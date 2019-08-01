package com.example.demo.controllers;

import com.example.demo.entities.Breed;
import com.example.demo.services.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/breed")
public class BreedController {
    private BreedService breedService;
    @Autowired
    public BreedController(BreedService breedService) {
        this.breedService = breedService;
    }

    @GetMapping(path = "/getBreeds")
    public List<Breed> getBreeds() {
        return breedService.getBreeds();
    }

    @PostMapping(path = "/createBreed")
    public Breed createBreed(@RequestParam String breedName,
                             @RequestParam int breedQuantity) {
        return breedService.createNewBreed(breedName, breedQuantity);
    }
}
