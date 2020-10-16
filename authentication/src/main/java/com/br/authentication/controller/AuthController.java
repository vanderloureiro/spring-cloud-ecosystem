package com.br.authentication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth/v1")
@RestController
public class AuthController {

    @PostMapping
    public ResponseEntity<String> login(String username) {
        
        return null;
    }

    @GetMapping
    public ResponseEntity<String> getUser() {

        return null;
    }
}