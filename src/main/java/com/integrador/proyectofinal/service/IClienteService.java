package com.integrador.proyectofinal.service;

import java.util.List;

import com.integrador.proyectofinal.models.Cliente;

public interface IClienteService {

    // Crear cliente
    public void saveCliente(Cliente cliente);

    // Lista completa de clientes
    public List<Cliente> getClientes();

    // Traer un cliente en particular
    public Cliente findCliente(Long id_cliente);

    // Eliminar cliente
    public void deleteCliente(Long id_cliente);

}
