package com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.repository;

import com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByDni(String dni);
    Optional<Cliente> findByCuenta(long cuenta);
}
