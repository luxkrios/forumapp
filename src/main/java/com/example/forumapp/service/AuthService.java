package com.example.forumapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forumapp.model.User;
import com.example.forumapp.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    
    public User registerUser(User user) {
    
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Kullanıcı adı zaten alınmış.");
        }
        
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("E-posta zaten kullanılıyor.");
        }
        return userRepository.save(user);
    }

   
    public Optional<User> authenticateUser(String username, String password) {
        return userRepository.findByUsername(username)
                .filter(user -> user.getPassword().equals(password));
    }
}
