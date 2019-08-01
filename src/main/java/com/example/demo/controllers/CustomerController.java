package com.example.demo.controllers;

import com.example.demo.entities.Customer;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    PATH VARIABLE: /firstName/Andrei/lastName/Astanei/age/21
    REQUEST PARAM: ...?firstName=Andrei&lastName=Astanei&age=21
 */

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    //Asta si Constructorul cu Autowired este in loc de @Inject
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(path = "/createCustomer")
    public Customer createCustomer(@RequestParam String firstName,
                                   @RequestParam String lastName,
                                   @RequestParam int age,
                                   @RequestParam boolean nebunLaCap) {

        return customerService.createCustomer(firstName, lastName, age, nebunLaCap);
    }

    @GetMapping(path = "/getAllCustomers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "/getCustomerById/{customerId}")
    public Customer getCustomerById(@PathVariable Integer customerId) {
        return customerService.getCustomerById(customerId);
    }

    @DeleteMapping(path = "/deleteCustomerById/{customerId}")
    public String deleteCustomerById(@PathVariable Integer customerId) {
        return customerService.deleteCustomerById(customerId);
    }

    @PutMapping(path = "/updateCustomerAgeById")
    public Customer updateCustomerAgeById(@RequestParam Integer customerId,
                                          @RequestParam int newCustomerAge) {
        return customerService.updateCustomerAgeById(customerId, newCustomerAge);
    }
}
