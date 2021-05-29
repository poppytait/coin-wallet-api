package com.poppytait.coinwalletapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InsufficientAmountException extends Exception {
    public InsufficientAmountException() {
        super("Amount cannot be 0 or less");
    }
}
