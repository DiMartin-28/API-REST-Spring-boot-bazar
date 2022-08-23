package com.integrador.proyectofinal.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.proyectofinal.dto.MayorVentaDTO;
import com.integrador.proyectofinal.models.Producto;
import com.integrador.proyectofinal.models.Venta;
import com.integrador.proyectofinal.repository.IProductoRepository;
import com.integrador.proyectofinal.repository.IVentaRepository;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepo;

    @Autowired 
    IProductoRepository productoRepo;

    @Override
    public Venta saveVenta(Venta venta) {
        Venta vent = venta;
        vent.setTotal(this.calcularTotal(venta));
        return ventaRepo.save(venta);
    }

    @Override
    public List<Venta> getVentas() {
        List<Venta> lista_ventas = ventaRepo.findAll();

        return lista_ventas;
    }

    @Override
    public Venta findVenta(Long codigo_venta) {
        Venta venta = ventaRepo.findById(codigo_venta).orElse(null);

        return venta;
    }

    @Override
    public void deleteVenta(Long codigo_venta) {
        ventaRepo.deleteById(codigo_venta);
    }

    // 5 Obtener los productos de una determinada venta
    @Override
    public List<Producto> productosVenta(Long codigo_venta) {
        Venta venta = this.findVenta(codigo_venta);
        List<Producto> lista_prodVentas = venta.getLista_productos();
        
        return lista_prodVentas;
    }

     /*    Obtener el codigo_venta, el total, la cantidad de productos, el nombre del cliente y el
           apellido del cliente de la venta con el monto más alto de todas.
           a. Métodos HTTP: GET b. Endpoint: localhost:8080/ventas/mayor_venta 
           */

    @Override
    public MayorVentaDTO mayVentDTO() {
        MayorVentaDTO ventaDTO = new MayorVentaDTO();

        Venta vent = new Venta();
        List<Venta> lista_ventas = this.getVentas();
        List<Double> lista_precios = new ArrayList<Double>();
        Double mayor = 0.0;
    
        for (Venta venta : lista_ventas) {
           lista_precios.add(venta.getTotal());
        }
        mayor = Collections.max(lista_precios);

        for (Venta venta : lista_ventas) {
            
            if(venta.getTotal() == mayor){
                vent = venta;
            }
        }
        
        ventaDTO.setCodigo_venta(vent.getCodigo_venta());
        ventaDTO.setTotal(vent.getTotal());
        ventaDTO.setCant_productos(vent.getLista_productos().size());
        ventaDTO.setNomb_cliente(vent.getUn_cliente().getNombre());
        ventaDTO.setApe_cliente(vent.getUn_cliente().getApellido());

        return ventaDTO;
    }
    
    // Mwtodo para calcular el total de la venta

    @Override
    public Double calcularTotal(Venta venta) {
        Double total = 0.0;

        List<Producto> lista_productos = venta.getLista_productos();

        for(int i = 0; i < lista_productos.size(); i++){

            Optional<Producto> lst_prod = productoRepo.findById(lista_productos.get(i).getCodigo_producto());

            total += lst_prod.get().getCosto();
        }
        return total;
    }
}