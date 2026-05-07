package com.uniguacu.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping
    public ResponseEntity<String> testGet() {
        return ResponseEntity.ok("O servidor está online! Tente agora o POST no Postman.");
    }

    @PostMapping
    public ResponseEntity<String> testPost() {
        return ResponseEntity.ok("OK");
    }
}