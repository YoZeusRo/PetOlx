package com.example.demo.repositories;

import com.example.demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

//Tipul pentru care vrem sa facem repository-ul asta si tipul id-ului
//El are o gramada de query-uri facute
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
