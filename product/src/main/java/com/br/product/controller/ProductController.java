package com.br.product.controller;

import java.util.Arrays;
import java.util.List;

import com.br.product.model.Product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/product/v1")
public class ProductController {

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Product>> getAll() {
        Product productA = new Product(1L, "iPhone", 300.0);
        Product productB = new Product(2L, "Television", 100.0);
        Product productC = new Product(3L, "Mouse", 8.0);
        
        return ResponseEntity.ok().body(
            Arrays.asList(productA, productB, productC)
        );
    }
    
}