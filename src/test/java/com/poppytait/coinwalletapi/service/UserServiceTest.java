package com.poppytait.coinwalletapi.service;

import com.poppytait.coinwalletapi.model.User;
import com.poppytait.coinwalletapi.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    IUserRepository repository;

    @InjectMocks
    UserService service;

    User user = new User("1", "poppy@gmail.com", "Poppy", "Tait");

    @Test
    void shouldGetUsers() {
        List<User> users = new ArrayList<>();
        users.add(user);

        when(repository.findAll()).thenReturn(users);

        List<User> actualUsers = service.getUsers();

        assertEquals(users, actualUsers);
    }
}
