package com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.service;

import com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.model.User;
import com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> login(String username, String password){
        return userRepository.findByUsername(username).filter(user -> user.getPassword().equals(password));
    }
}
