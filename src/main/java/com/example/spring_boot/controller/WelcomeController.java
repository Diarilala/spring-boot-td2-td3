package com.example.spring_boot.controller;

import com.example.spring_boot.service.WelcomeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor

@RestController
public class WelcomeController {

    private final WelcomeService welcomeService;

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestParam String name) {

        if(name.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("No name provided");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Welcome " + name);
    }
}
