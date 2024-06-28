package com.example.xx2.service;

import com.example.xx2.model.accounts.ERole;
import com.example.xx2.model.accounts.Role;
import com.example.xx2.model.accounts.User;
import com.example.xx2.repository.RoleRepository;
import com.example.xx2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void createUserPostLogin(String username, String email) {
        Role role = roleRepository.findByName(ERole.ROLE_USER);
        Set<Role> roles = new HashSet<>(Collections.singletonList(role));

        User user = getByUsername(email);
        if(user == null){
            user = User.builder()
                    .username(username)
                    .email(email)
                    .roles(roles)
                    .build();
            userRepository.save(user);
        }
    }

    @Override
    public User getByUsername(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        return userOptional.orElse(null);
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
