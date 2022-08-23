package com.integrador.proyectofinal.controller;

import java.util.List;

import com.integrador.proyectofinal.models.Producto;
import com.integrador.proyectofinal.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    @Autowired

    private ProductoService productServ;

    // Crear producto
    @PostMapping("/productos/crear")
    public String createProduct(@RequestBody Producto producto) {
        productServ.saveProducto(producto);
        return "Producto creado correctamente";
    }

    // Lista completa de productos
    @GetMapping("/productos")
    public List<Producto> getProductos() {
        return productServ.getProductos();
    }

    // Traer un producto en particular
    @GetMapping("/productos/traer/{codigo_producto}")
    public Producto getProducto(@PathVariable Long codigo_producto) {
        return productServ.findProducto(codigo_producto);
    }

    // Eliminacion
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto) {
        productServ.deleteProducto(codigo_producto);
        return "Producto eliminado correctamente";
    }

    // Edicion 
    @PutMapping("/productos/editar/{codigo_producto}")
    public String editProducto(@PathVariable Long codigo_producto, @RequestBody Producto producto) {

        Producto prod = new Producto();
        String modificado = "";
        if(producto.getCodigo_producto() == codigo_producto){
            prod = producto;
            productServ.saveProducto(prod);
            modificado = "Producto modificado correctamente";
        }
        else{
            modificado = "Producto no modificado";
        }
        return modificado;
    }

    @GetMapping("/productos/falta_stock")
    public List<Producto> faltaStock(){
        List<Producto> lista_productos = productServ.menosDeCinco();

        return lista_productos;
    }
}
