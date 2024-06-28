package com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.controller;

import com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.model.User;
import com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        System.out.println("Usuario recibido: " + user.getUsername() + "/" + user.getPassword());
        return ResponseEntity.ok(userService.register(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        Optional<User> loggedInUser = userService.login(user.getUsername(), user.getPassword());
        if(loggedInUser.isPresent()){
            return ResponseEntity.ok("Acceso Correcto");
        } else {
            return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
        }
    }

}
