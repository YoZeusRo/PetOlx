package com.example.demo.controllers;

import com.example.demo.entities.Order;
import com.example.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path = "/getOrders")
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping(path = "createNewOrder")
    public Order createNewOrder(@RequestParam Integer customerID,
                                @RequestParam Integer dogId) {
        return null;
    }
}
