package com.example.formapp.service;

import com.example.formapp.model.User;
import com.example.formapp.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {
    @Autowired private UserRepository repo;

    public User saveUser(User user) throws Exception {
        if (repo.findByEmail(user.getEmail()).isPresent())
            throw new Exception("Email already exists");
        if (repo.findByPhoneNumber(user.getPhoneNumber()).isPresent())
            throw new Exception("Phone number already exists");
        return repo.save(user);
    }
}

