package com.poppytait.coinwalletapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IdenticalSenderAndDestinationException extends Exception {
    public IdenticalSenderAndDestinationException(String senderWalletId, String destinationWalletId) {
        super("Sender wallet with id " + senderWalletId + " should not be equal to destination wallet with id " + destinationWalletId);
    }
}
