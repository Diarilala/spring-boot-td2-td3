package com.example.spring_boot.controller;

import com.example.spring_boot.service.WelcomeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor

@RestController
public class WelcomeController {

    private final WelcomeService welcomeService;

    @GetMapping("/welcome")
    public String welcome(@RequestParam String name) {
        return welcomeService.welcomeMessage(name);
    }
}
