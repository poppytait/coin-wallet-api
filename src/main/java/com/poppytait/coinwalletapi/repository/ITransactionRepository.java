package com.poppytait.coinwalletapi.repository;

import com.poppytait.coinwalletapi.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ITransactionRepository extends MongoRepository<Transaction, String> {
}
