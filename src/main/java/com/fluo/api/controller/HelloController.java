package com.fluo.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    public record ApplicationStatus(String status, String app) {}

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello! Welcome to Fluo.");
    }

    @GetMapping("/status")
    public ResponseEntity<ApplicationStatus> checkStatus() {
        ApplicationStatus statusInfo = new ApplicationStatus("OK", "Fluo");
        return ResponseEntity.ok(statusInfo);
    }
}
