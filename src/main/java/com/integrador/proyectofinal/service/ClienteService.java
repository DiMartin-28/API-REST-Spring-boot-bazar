package com.integrador.proyectofinal.service;

import java.util.List;
import com.integrador.proyectofinal.models.Cliente;
import com.integrador.proyectofinal.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepo;

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public List<Cliente> getClientes() {
        List<Cliente> lista_clientes = clienteRepo.findAll();
        return lista_clientes;
    }

    @Override
    public Cliente findCliente(Long id_cliente) {
        Cliente cliente = clienteRepo.findById(id_cliente).orElse(null);
        return cliente;
    }

    @Override
    public void deleteCliente(Long id_cliente) {
        clienteRepo.deleteById(id_cliente);
    }
    
}
