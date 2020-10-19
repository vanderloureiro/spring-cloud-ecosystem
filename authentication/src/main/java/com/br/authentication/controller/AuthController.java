package com.br.authentication.controller;

import com.br.authentication.service.TokenService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth/v1")
@RestController
public class AuthController {

    private TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping("/token/{username}")
    public ResponseEntity<String> login(@PathVariable String username) {
        
        return ResponseEntity.ok().body(this.tokenService.generateToken(username));
    }

    @GetMapping("/username")
    public ResponseEntity<String> getUsername(@RequestHeader(value = "Authorization") String token) {

        return ResponseEntity.ok().body(this.tokenService.getUsername(token));
    }

    @GetMapping("/is-authenticaed")
    public ResponseEntity<Boolean> isAuthenticated(@RequestHeader(value = "Authorization") String token) {

        return ResponseEntity.ok().body(this.tokenService.isValid(token));
    }
}