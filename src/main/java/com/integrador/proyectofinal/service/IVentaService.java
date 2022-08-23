package com.integrador.proyectofinal.service;

import java.util.List;

import com.integrador.proyectofinal.dto.MayorVentaDTO;
import com.integrador.proyectofinal.models.Producto;
import com.integrador.proyectofinal.models.Venta;

public interface IVentaService {

    // Crear una venta nueva
    public Venta saveVenta(Venta venta);

    // Traer todas las ventas
    public List<Venta> getVentas();

    // Traer una venta en particular
    public Venta findVenta(Long codigo_venta);

    // Eliminacion 
    public void deleteVenta(Long codigo_venta);

    // Obtener los productos de una determinada venta
    public List<Producto> productosVenta(Long codigo_venta);

    /*  Obtener el codigo_venta, el total, la cantidad de productos, el nombre del cliente y el
        apellido del cliente de la venta con el monto más alto de todas.
        a. Métodos HTTP: GET b. Endpoint: localhost:8080/ventas/mayor_venta */

    public MayorVentaDTO mayVentDTO();

    // Metodo para calcular el total de la venta
    public Double calcularTotal(Venta venta);

}
