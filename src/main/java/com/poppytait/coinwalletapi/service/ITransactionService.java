package com.poppytait.coinwalletapi.service;

import com.poppytait.coinwalletapi.exception.IdenticalSenderAndDestinationException;
import com.poppytait.coinwalletapi.exception.InsufficientAmountException;
import com.poppytait.coinwalletapi.exception.InsufficientFundsException;
import com.poppytait.coinwalletapi.exception.WalletNotFoundException;
import com.poppytait.coinwalletapi.model.Transaction;
import com.poppytait.coinwalletapi.model.TransactionRequest;

import java.util.List;

public interface ITransactionService {
    void makeTransaction(TransactionRequest request) throws WalletNotFoundException, InsufficientFundsException, IdenticalSenderAndDestinationException, InsufficientAmountException;
    List<Transaction> getTransactions();
}
