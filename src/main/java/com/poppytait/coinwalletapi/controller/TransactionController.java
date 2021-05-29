package com.poppytait.coinwalletapi.controller;

import com.poppytait.coinwalletapi.exception.IdenticalSenderAndDestinationException;
import com.poppytait.coinwalletapi.exception.InsufficientAmountException;
import com.poppytait.coinwalletapi.exception.InsufficientFundsException;
import com.poppytait.coinwalletapi.exception.WalletNotFoundException;
import com.poppytait.coinwalletapi.model.Transaction;
import com.poppytait.coinwalletapi.model.TransactionRequest;
import com.poppytait.coinwalletapi.service.ITransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transactions")
public class TransactionController {
    private final ITransactionService transactionService;

    public TransactionController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/")
    public void makeTransaction(@RequestBody TransactionRequest transaction) throws WalletNotFoundException, InsufficientFundsException, IdenticalSenderAndDestinationException, InsufficientAmountException {
        transactionService.makeTransaction(transaction);
    }

    @GetMapping("/")
    public List<Transaction> getTransactions() {
        return transactionService.getTransactions();
    }
}
