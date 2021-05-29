package com.poppytait.coinwalletapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WalletNotFoundException extends Exception {
    public WalletNotFoundException(String walletId) {
        super("Wallet with id " + walletId + " not found");
    }
}
