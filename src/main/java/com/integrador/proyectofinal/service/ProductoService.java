package com.integrador.proyectofinal.service;

import java.util.ArrayList;
import java.util.List;

import com.integrador.proyectofinal.models.Producto;
import com.integrador.proyectofinal.repository.IProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productRepo;

    @Override
    public void saveProducto(Producto producto) {
        productRepo.save(producto);
    }

    @Override
    public List<Producto> getProductos() {
        List<Producto> lista_productos = productRepo.findAll();
        return lista_productos;
    }

    @Override
    public Producto findProducto(Long codigo_producto) {
        return productRepo.findById(codigo_producto).orElse(null);
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
        Producto prod = this.findProducto(codigo_producto);
        productRepo.delete(prod);
    }

    // Funcion para devolver la lista de productos de cantidad < 5
    public List<Producto> menosDeCinco() {
        List<Producto> lista_productos = productRepo.findAll();
        List<Producto> lista_stock = new ArrayList<Producto>();

        for (Producto prod : lista_productos) {
            if (prod.getCantidad_disponible() < 5){
                lista_stock.add(prod);
            }
        }
        return lista_stock;
      
    }
}
