package com.poppytait.coinwalletapi.service;

import com.poppytait.coinwalletapi.model.User;
import com.poppytait.coinwalletapi.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    private final IUserRepository repository;

    public UserService(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }
}
