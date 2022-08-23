package com.integrador.proyectofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.integrador.proyectofinal.dto.MayorVentaDTO;
import com.integrador.proyectofinal.models.Producto;
import com.integrador.proyectofinal.models.Venta;
//import com.integrador.proyectofinal.repository.IVentaRepository;
import com.integrador.proyectofinal.service.VentaService;

@RestController
public class VentaController {

  @Autowired
  private VentaService ventaServ;

  // Crear venta
  @PostMapping("/ventas/crear")
  public String saveVenta(@RequestBody Venta venta){

    ventaServ.saveVenta(venta);

    return "Venta ingresada correctamente";
  }

  // Traer todas las ventas
  @GetMapping("/ventas")
  public List<Venta> getVentas(){
    List<Venta> lista_ventas = ventaServ.getVentas();

    return lista_ventas;
  }

  // Traer una venta en particular
  @GetMapping("ventas/{codigo_venta}")
  public Venta getVenta(@PathVariable Long codigo_venta){
    Venta venta = ventaServ.findVenta(codigo_venta);

    return venta;
  }

  // Eliminacion
  @DeleteMapping("/ventas/eliminar/{codigo_venta}")
  public String deleteVenta(@PathVariable Long codigo_venta){
    ventaServ.deleteVenta(codigo_venta);

    return "Venta eliminada correctamente";
  }

  // Edicion  revisar este metodo
  @PutMapping("/ventas/editar/{codigo_venta}")
  public Venta editVenta(@PathVariable Long codigo_venta, @RequestBody Venta venta){
   Venta vent = new Venta();
   if(venta.getCodigo_venta() == codigo_venta){

    vent = venta;
    ventaServ.saveVenta(vent);
   }
    return vent;
  }

  // Obtener los productos de una determinada venta  "/ventas/productos/{codigo_venta}"
  @GetMapping("/ventas/productos/{codigo_venta}")
  public List<Producto> productosVenta(@PathVariable Long codigo_venta){
    
    return ventaServ.productosVenta(codigo_venta);
  }

  // Calcular la venta con el mayot monto
  @GetMapping("/ventas/mayor_venta")
  public MayorVentaDTO mayorVentaDTO(){

    return ventaServ.mayVentDTO();
  }
}
