/*
 * Copyright (c) 2026 Fluo API. All rights reserved.
 * This software is proprietary. Unauthorized copying, redistribution,
 * or commercial use is strictly prohibited under the terms defined
 * in the project's LICENSE and README.md.
 */
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
