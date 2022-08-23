package com.integrador.proyectofinal.controller;

import java.util.List;

import com.integrador.proyectofinal.models.Cliente;
import com.integrador.proyectofinal.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteServ;

    // Crear un cliente
    @PostMapping("/clientes/crear")
    public String createCliente(@RequestBody Cliente cliente) {
        clienteServ.saveCliente(cliente);
        return "Cliente creado correctamente";
    }

    // Traer clientes
    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return clienteServ.getClientes();
    }

    // Traer un cliente por su id
    @GetMapping("/clientes/{id_cliente}")
    public Cliente getCliente(@PathVariable Long id_cliente) {
        Cliente cliente = clienteServ.findCliente(id_cliente);

        return cliente;
    }

    // Eliminacion
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente) {
        clienteServ.deleteCliente(id_cliente);
        return "Cliente eliminado correctamente";
    }

    // Edicion volver a controlar este metodo
    @PutMapping("/clientes/editar/{id_cliente}")
    public String editCliente(@PathVariable Long id_cliente, @RequestBody Cliente cliente) {

        Cliente cli = new Cliente();
        String modificado = "";
        if( cliente.getId_cliente() == id_cliente){
            cli = cliente;
            clienteServ.saveCliente(cli);
            modificado = "Cliente modificado correctamente";
        }
        else{
            modificado = "Ocurrio un error al modificar el cliente "+ id_cliente;
        }
        return modificado;
    }
}
