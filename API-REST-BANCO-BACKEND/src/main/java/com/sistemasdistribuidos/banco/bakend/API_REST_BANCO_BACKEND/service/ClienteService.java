package com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.service;

import com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.model.Cliente;
import com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.model.Movimiento;
import com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.repository.ClienteRepository;
import com.sistemasdistribuidos.banco.bakend.API_REST_BANCO_BACKEND.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    //@Autowired
    //private MovimientoRepository movimientoRepository;

    public Cliente register(Cliente cliente){return clienteRepository.save(cliente);}

    public List<Cliente> getAllClientes(){return clienteRepository.findAll();}

    public Optional<Cliente> login(String dni, String contrasena){
        return clienteRepository.findByDni(dni).filter(cliente -> cliente.getContrasena().equals(contrasena));
    }

    public Optional<Cliente> getClienteByDni(String dni) {
        return clienteRepository.findByDni(dni);
    }

    public Optional<Cliente> getClienteByCuenta(long cuenta) {
        return clienteRepository.findByCuenta(cuenta);
    }

    public Cliente updateSaldo(String dni, long amount) {
        Cliente cliente = clienteRepository.findByDni(dni).orElseThrow();
        cliente.setSaldo(cliente.getSaldo() + amount);
        return clienteRepository.save(cliente);
    }

    public Cliente retirarSaldo(String dni, long amount) {
        Cliente cliente = clienteRepository.findByDni(dni).orElseThrow();
        cliente.setSaldo(cliente.getSaldo() - amount);
        return clienteRepository.save(cliente);
    }

    public Cliente transferirSaldo(long fromCuenta, long toCuenta, long amount) {
        Cliente fromCliente = clienteRepository.findByCuenta(fromCuenta).orElseThrow();
        Cliente toCliente = clienteRepository.findByCuenta(toCuenta).orElseThrow();

        fromCliente.setSaldo(fromCliente.getSaldo() - amount);
        toCliente.setSaldo(toCliente.getSaldo() + amount);

        clienteRepository.save(toCliente);
        return clienteRepository.save(fromCliente);
    }

    /*public List<Movimiento> getMovimientos(long cuenta) {
        Optional<Cliente> clienteOpt = clienteRepository.findByCuenta(cuenta);
        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            return movimientoRepository.findByCliente(cliente);
        }
        return null;
    }*/
}