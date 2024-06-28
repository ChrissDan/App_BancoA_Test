package com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.repository;

import com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.model.Cliente;
import com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByCliente(Cliente cliente);
}
