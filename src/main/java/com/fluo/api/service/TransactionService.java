package com.fluo.api.service;

import com.fluo.api.dto.TransactionRequest;
import com.fluo.api.dto.TransactionResponse;
import com.fluo.api.exception.ResourceNotFoundException;
import com.fluo.api.mapper.TransactionMapper;
import com.fluo.api.model.Category;
import com.fluo.api.model.Transaction;
import com.fluo.api.repository.CategoryRepository;
import com.fluo.api.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final CategoryRepository categoryRepository;

    public TransactionService(TransactionRepository transactionRepository,
                              TransactionMapper transactionMapper,
                              CategoryRepository categoryRepository) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public List<TransactionResponse> getAll() {
        return transactionRepository.findAll().stream()
                .map(transactionMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public TransactionResponse add(TransactionRequest transactionRequest) {
        Category category = categoryRepository.findById(transactionRequest.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Unable to add transaction: Category not found"));

        Transaction transaction = Transaction.builder()
                .description(transactionRequest.getDescription())
                .amount(transactionRequest.getAmount())
                .date(transactionRequest.getDate())
                .type(transactionRequest.getType())
                .category(category)
                .build();

        Transaction savedTransaction = transactionRepository.save(transaction);
        return transactionMapper.toResponse(savedTransaction);
    }

    @Transactional
    public void delete(Long id) {
        if (!transactionRepository.existsById(id)) {
            throw new ResourceNotFoundException("Unable to delete: Transaction not found with id: " + id);
        }

        transactionRepository.deleteById(id);
    }
}
