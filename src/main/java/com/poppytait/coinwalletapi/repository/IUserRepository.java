package com.poppytait.coinwalletapi.repository;

import com.poppytait.coinwalletapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRepository extends MongoRepository<User, String> {
}
