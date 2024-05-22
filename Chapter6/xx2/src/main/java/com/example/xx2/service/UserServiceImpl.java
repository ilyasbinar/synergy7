package com.example.xx2.service;

import com.example.xx2.model.accounts.User;
import com.example.xx2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    final
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getById(UUID uuid) {
        return userRepository.findById(uuid).orElseThrow();
    }

    @Override
    public boolean takePayment(User user, long price) {
        if(user.getBalance() >= price){
            user.setBalance(user.getBalance()-price);
            userRepository.save(user);
            return true;
        }else{
            return false;
        }
    }
}
