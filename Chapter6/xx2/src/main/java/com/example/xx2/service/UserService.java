package com.example.xx2.service;

import com.example.xx2.model.accounts.User;

import java.util.UUID;

public interface UserService {
    void createUserPostLogin(String name, String email);

    User getByUsername(String username);

    User getById(UUID uuid);
    boolean takePayment(User user, long price);
}
