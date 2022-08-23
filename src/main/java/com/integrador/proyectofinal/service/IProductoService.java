package com.integrador.proyectofinal.service;

import java.util.List;

import com.integrador.proyectofinal.models.Producto;

public interface IProductoService {

    // Crear nuevo producto
    public void saveProducto(Producto producto);

    // Lista completa de productos
    public List<Producto> getProductos();

    // Traer un producto en particular
    public Producto findProducto(Long codigo_producto);

    // Eliminar producto
    public void deleteProducto(Long codigo_producto);

    // Funcion Lista producto de menos de 5 unidades
    public List<Producto> menosDeCinco();

}
