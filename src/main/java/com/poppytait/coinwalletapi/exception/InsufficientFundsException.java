package com.poppytait.coinwalletapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigDecimal;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String senderWalletId, BigDecimal senderWalletBalance, BigDecimal amount) {
        super("Wallet with id " + senderWalletId + " has insufficient funds. Balance is " + senderWalletBalance + " and tried to send " + amount);
    }
}

