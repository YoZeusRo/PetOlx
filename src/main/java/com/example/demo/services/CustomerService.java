package com.example.demo.services;

import com.example.demo.entities.Customer;
import com.example.demo.exceptions.NoEntityFoundException;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
    In Service facem toata logica si functionalitatea, nu in celelalte doua (componente)! -> Controller si Repository
 */

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(String firstName, String lastName, int age, boolean nebunLaCap) {
        Customer createdCustomer = Customer.builder().firstName(firstName)
                .lastName(lastName)
                .age(age)
                .nebunLaCap(nebunLaCap)
                .build();

        //salvare in DB
        customerRepository.save(createdCustomer);

        //ca sa il avem si ca raspuns in PostMan sub forma JSON
        return createdCustomer;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Integer customerId) {
        Optional<Customer> lookedForCustomer = customerRepository.findById(customerId);

        if(lookedForCustomer.isPresent()) {
            return lookedForCustomer.get();
        } else {
            throw new NoEntityFoundException(Customer.class, customerId);
        }
    }

    public String deleteCustomerById(Integer customerId) {
        try {
            customerRepository.deleteById(customerId);

            return "Successfully deleted the customer with id " + customerId;
        } catch (EmptyResultDataAccessException e) {
            return "Customer with id " + customerId + " not found!";
        }
    }

    public Customer updateCustomerAgeById(Integer customerId, int newCustomerAge) {
        Optional<Customer> customer = customerRepository.findById(customerId);

        if(customer.isPresent()) {
            Customer customerToBeUpdated = customer.get();
            customerToBeUpdated.setAge(newCustomerAge);
            customerRepository.save(customerToBeUpdated);

            return customerToBeUpdated;
        } else {
            throw new NoEntityFoundException(Customer.class, customerId);
        }
    }
}
