package com.poppytait.coinwalletapi.service;

import com.poppytait.coinwalletapi.exception.WalletNotFoundException;
import com.poppytait.coinwalletapi.model.Wallet;

import java.math.BigDecimal;
import java.util.List;

public interface IWalletService {
    List<Wallet> getWallets(String userId);
    Wallet getWallet(String walletId) throws WalletNotFoundException;
    void updateBalance(String walletId, BigDecimal amount) throws WalletNotFoundException;
}
