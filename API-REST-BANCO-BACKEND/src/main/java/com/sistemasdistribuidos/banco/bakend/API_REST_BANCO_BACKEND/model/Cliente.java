package com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private long cuenta;
    private long saldo;
    private String contrasena;

    @OneToMany(mappedBy = "cliente")
    private List<Movimiento> movimientos;

}
