package com.example.demo.controllers;

import com.example.demo.entities.Dog;
import com.example.demo.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/dog")
public class DogController {
    private DogService dogService;
    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping(path = "/getDogs")
    public List<Dog> getDogs() {
        return dogService.getDogs();
    }

    @PostMapping(path = "/createNewDog")
    public Dog createNewDog(@RequestParam Integer breedId,
                            @RequestParam String dogName,
                            @RequestParam String dogGender,
                            @RequestParam int dogAge,
                            @RequestParam boolean isDogSterilized) {
        return dogService.createNewDog(breedId, dogName, dogGender, dogAge, isDogSterilized);
    }
}
