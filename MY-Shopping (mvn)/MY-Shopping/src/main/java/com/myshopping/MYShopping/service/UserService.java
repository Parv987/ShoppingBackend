package com.myshopping.MYShopping.service;

import com.myshopping.MYShopping.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myshopping.MYShopping.repository.UserRepository;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public void registerUser(AppUser user){
        userRepository.save(user);
    }

    public AppUser getUserById(UUID id){
        AppUser user= userRepository.findById(id).orElse(null);
        return user;
    }
}
