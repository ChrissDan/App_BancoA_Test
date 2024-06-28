package com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.service;

import com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.model.Cliente;
import com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.model.Movimiento;
import com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    public List<Movimiento> getMovimientosByCliente(Cliente cliente) {
        return movimientoRepository.findByCliente(cliente);
    }
}
