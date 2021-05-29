package com.poppytait.coinwalletapi.controller;

import com.poppytait.coinwalletapi.model.Wallet;
import com.poppytait.coinwalletapi.service.IWalletService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wallets")
public class WalletController {
    private final IWalletService service;

    public WalletController(IWalletService service) {
        this.service = service;
    }

    @GetMapping("/{userId}")
    public List<Wallet> getWalletsByUserId(@PathVariable String userId) {
        return service.getWallets(userId);
    }
}
