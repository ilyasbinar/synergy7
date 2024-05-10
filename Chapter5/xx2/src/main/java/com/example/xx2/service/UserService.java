package com.example.xx2.service;

import com.example.xx2.model.User;

import java.util.UUID;

public interface UserService {

    User getById(UUID uuid);
    boolean takePayment(User user, long price);
}
