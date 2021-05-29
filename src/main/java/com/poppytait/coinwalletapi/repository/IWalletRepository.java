package com.poppytait.coinwalletapi.repository;

import com.poppytait.coinwalletapi.model.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IWalletRepository extends MongoRepository<Wallet, String> {
    List<Wallet> getWalletsByUserId(String userId);
}
