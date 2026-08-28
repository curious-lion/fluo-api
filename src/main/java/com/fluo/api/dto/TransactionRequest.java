package com.fluo.api.dto;

import com.fluo.api.model.TransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionRequest {

    @NotBlank(message = "Description is required.")
    @Size(max = 255, message = "Description must not exceed {max} characters.")
    private String description;

    @NotNull(message = "Amount is required.")
    @Positive(message = "Amount must be positive.")
    private BigDecimal amount;

    @NotNull(message = "Date is required.")
    private LocalDateTime date;

    @NotNull(message = "Transaction type (INCOME/EXPENSE) is required.")
    private TransactionType type;

    @NotNull(message = "Category ID is required.")
    private Long categoryId;
}
