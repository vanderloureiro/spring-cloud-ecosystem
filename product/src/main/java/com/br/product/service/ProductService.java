package com.br.product.service;

import java.util.Arrays;
import java.util.List;

import com.br.product.client.AuthenticationClient;
import com.br.product.model.Product;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private AuthenticationClient authenticationClient;

    public ProductService(AuthenticationClient authenticationClient) {
        this.authenticationClient = authenticationClient;
    }

    public List<Product> getAll(String token) throws Exception {

        if (this.authenticationClient.isValid(token)) {

            Product productA = new Product(1L, "iPhone", 300.0);
            Product productB = new Product(2L, "Television", 100.0);
            Product productC = new Product(3L, "Mouse", 8.0);
    
            return Arrays.asList(productA, productB, productC);
        
        } else {
            throw new Exception("Not authorized");
        }

    }
}