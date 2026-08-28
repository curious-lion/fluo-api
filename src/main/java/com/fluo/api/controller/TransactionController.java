package com.fluo.api.controller;

import com.fluo.api.dto.TransactionRequest;
import com.fluo.api.dto.TransactionResponse;
import com.fluo.api.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<List<TransactionResponse>> getAll() {
        return ResponseEntity.ok(transactionService.getAll());
    }

    @PostMapping
    public ResponseEntity<TransactionResponse> add(@Valid @RequestBody TransactionRequest transactionRequest) {
        TransactionResponse transactionResponse = transactionService.add(transactionRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        transactionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
