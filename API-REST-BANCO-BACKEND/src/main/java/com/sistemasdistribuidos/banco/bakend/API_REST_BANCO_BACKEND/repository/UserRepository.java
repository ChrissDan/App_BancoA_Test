package com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.repository;

import com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
