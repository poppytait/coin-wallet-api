package com.poppytait.coinwalletapi.service;

import com.poppytait.coinwalletapi.exception.WalletNotFoundException;
import com.poppytait.coinwalletapi.model.Wallet;
import com.poppytait.coinwalletapi.repository.IWalletRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class WalletService implements IWalletService {
    private final IWalletRepository repository;


    public WalletService(IWalletRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Wallet> getWallets(String userId) {
        return repository.getWalletsByUserId(userId);
    }

    @Override
    public Wallet getWallet(String walletId) throws WalletNotFoundException {
        return repository.findById(walletId)
                .orElseThrow(() -> new WalletNotFoundException(walletId));
    }

    @Override
    @Transactional
    public void updateBalance(String walletId, BigDecimal amount) throws WalletNotFoundException {
        Wallet wallet = getWallet(walletId);
        BigDecimal balance = wallet.getBalance();
        wallet.setBalance(balance.add(amount));

        repository.save(wallet);
        // repository.save(new Wallet("1", "user1", new BigDecimal(200)))
    }
}
