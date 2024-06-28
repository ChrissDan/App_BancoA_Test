package com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.controller;

import com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.model.Cliente;
import com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.model.Movimiento;
import com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.service.ClienteService;
import com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("http://localhost:3000")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    //@Autowired
    //private MovimientoService movimientoService;

    @PostMapping("/register")
    public ResponseEntity<Cliente> register(@RequestBody Cliente cliente){
        System.out.println("Cliente recibido: " + cliente.getDni() + "/" + cliente.getContrasena());
        return ResponseEntity.ok(clienteService.register(cliente));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes(){ return ResponseEntity.ok((clienteService.getAllClientes()));}

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Cliente cliente){
        Optional<Cliente> loggedInCliente = clienteService.login(cliente.getDni(), cliente.getContrasena());
        System.out.println(cliente.getDni() + "/" + cliente.getContrasena());
        if (loggedInCliente.isPresent()){
            return ResponseEntity.ok("Acceso Correcto");
        } else {
            return ResponseEntity.status(401).body("DNI o Contraseña incorrectos");
        }
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<Object> getClienteByDni(@PathVariable String dni) {
        Optional<Cliente> cliente = clienteService.getClienteByDni(dni);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente con DNI " + dni + " no encontrado.");
        }
    }

    @GetMapping("/cuenta/{cuenta}")
    public ResponseEntity<Object> getClienteByCuenta(@PathVariable long cuenta) {
        Optional<Cliente> cliente = clienteService.getClienteByCuenta(cuenta); // Asegúrate de tener este método en el servicio
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente con cuenta " + cuenta + " no encontrado.");
        }
    }


    @PutMapping("/update-saldo/{dni}")
    public ResponseEntity<Cliente> updateSaldo(@PathVariable String dni, @RequestParam long amount) {
        Cliente updatedCliente = clienteService.updateSaldo(dni, amount);
        return ResponseEntity.ok(updatedCliente);
    }

    @PutMapping("/retirar-saldo/{dni}")
    public ResponseEntity<Cliente> retirarSaldo(@PathVariable String dni, @RequestParam long amount) {
        Cliente updatedCliente = clienteService.retirarSaldo(dni, amount);
        return ResponseEntity.ok(updatedCliente);
    }

    @PutMapping("/transferir-saldo/{fromCuenta}/{toCuenta}")
    public ResponseEntity<Cliente> transferirSaldo(@PathVariable long fromCuenta, @PathVariable long toCuenta, @RequestParam long amount) {
        Cliente updatedCliente = clienteService.transferirSaldo(fromCuenta, toCuenta, amount);
        return ResponseEntity.ok(updatedCliente);
    }

    /*@GetMapping("/{cuenta}/movimientos")
    public ResponseEntity<List<Movimiento>> getMovimientos(@PathVariable long cuenta) {
        List<Movimiento> movimientos = clienteService.getMovimientos(cuenta);
        return ResponseEntity.ok(movimientos);
    }*/
}