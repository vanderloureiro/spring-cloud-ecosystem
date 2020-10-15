package com.br.customer.controller;

import java.util.Arrays;
import java.util.List;

import com.br.customer.model.Customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer/api/v1")
public class CustomerController {

    @GetMapping
    public ResponseEntity<List<Customer>> getAll() {
        Customer customerA = new Customer(1L, "John");
        Customer customerB = new Customer(1L, "Phillip");
        Customer customerC = new Customer(1L, "Mary");

        return ResponseEntity.ok().body(
            Arrays.asList(customerA, customerB, customerC)
        );
    }
}