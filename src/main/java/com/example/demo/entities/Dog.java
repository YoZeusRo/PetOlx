package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer dogId;

    private String name;

    private boolean sterilized;

    private int age;

    private String gender;

    @ManyToOne
    private Breed breed;

    @OneToOne
    private Order order;
}
