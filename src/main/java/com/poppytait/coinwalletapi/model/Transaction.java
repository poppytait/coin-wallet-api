package com.poppytait.coinwalletapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@Document(collection = "transactions")
public class Transaction {

    @Transient
    public static final String SEQUENCE_NAME = "transactions_sequence";

    @Id
    private String id;

    private String sourceWalletId;
    private String destinationWalletId;
    private BigDecimal amount;
    private Instant sentAt;
    private String reference;

    public Transaction(String id, String sourceWalletId, String destinationWalletId, BigDecimal amount, Instant sentAt, String reference) {
        this.id = id;
        this.sourceWalletId = sourceWalletId;
        this.destinationWalletId = destinationWalletId;
        this.amount = amount;
        this.sentAt = sentAt;
        this.reference = reference;
    }
}