package com.fluo.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello! Welcome to Fluo.";
    }

    @GetMapping("/status")
    public String checkStatus() {
        return "{\"status\": \"OK\", \"app\": \"Fluo\"}";
    }
}
