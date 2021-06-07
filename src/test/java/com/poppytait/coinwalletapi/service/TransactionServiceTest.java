package com.poppytait.coinwalletapi.service;

import com.poppytait.coinwalletapi.model.Transaction;
import com.poppytait.coinwalletapi.model.TransactionRequest;
import com.poppytait.coinwalletapi.model.Wallet;
import com.poppytait.coinwalletapi.repository.ITransactionRepository;
import com.poppytait.coinwalletapi.repository.IWalletRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {
    @Captor
    ArgumentCaptor<Transaction> transactionArgumentCaptor;

    @Captor
    ArgumentCaptor<Wallet> walletCaptor;

    @Mock
    ITransactionRepository transactionRepository;

    @Mock
    IWalletRepository walletRepository;

    @Mock
    IWalletService walletService;

    @InjectMocks
    TransactionService transactionService;

    @InjectMocks
    SequenceGeneratorService sequenceGeneratorService;

    Instant instant = Instant.now();
    Transaction transaction = new Transaction("101", "99", "2", new BigDecimal(100), instant, "reference");
    TransactionRequest request = new TransactionRequest("99", "2", new BigDecimal(100), instant, "reference");
    Wallet sourceWallet = new Wallet("99", "1", new BigDecimal(200));
    Wallet destinationWallet = new Wallet("88", "2", new BigDecimal(50));

    @Test
    void shouldGetTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        when(transactionRepository.findAll()).thenReturn(transactions);

        List<Transaction> actualTransactions = transactionService.getTransactions();

        assertEquals(transactions, actualTransactions);
    }
}