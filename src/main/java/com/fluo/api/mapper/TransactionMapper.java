package com.fluo.api.mapper;

import com.fluo.api.dto.TransactionResponse;
import com.fluo.api.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public TransactionResponse toResponse(Transaction transaction) {
        if (transaction == null) {
            return null;
        }

        return new TransactionResponse(
                transaction.getId(),
                transaction.getDescription(),
                transaction.getAmount(),
                transaction.getDate(),
                transaction.getType(),
                transaction.getCategory() != null ? transaction.getCategory().getName() : null
        );
    }
}
