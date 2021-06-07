package com.poppytait.coinwalletapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
public class TransactionRequest {
    private String sourceWalletId;
    private String destinationWalletId;
    private BigDecimal amount;
    private Instant sentAt;
    private String reference;

    public TransactionRequest(String sourceWalletId, String destinationWalletId, BigDecimal amount, Instant sentAt, String reference) {
        this.sourceWalletId = sourceWalletId;
        this.destinationWalletId = destinationWalletId;
        this.amount = amount;
        this.sentAt = sentAt;
        this.reference = reference;
    }
}