package com.integrador.proyectofinal.models;

import java.time.LocalDate;
import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private Double total;

    @ManyToMany
        @JoinTable(
            name = "lista_productos_ventas",
            joinColumns = {@JoinColumn(name = "codigo_venta")},
            inverseJoinColumns = {@JoinColumn(name = "codigo_producto")}
        )
    private List<Producto> lista_productos;

    @JoinColumn(name = "un_cliente_id_cliente", referencedColumnName = "id_cliente")
    @OneToOne
    private Cliente un_cliente;
    
    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, List<Producto> lista_productos, Double total,
            Cliente cliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.lista_productos = lista_productos;
        this.un_cliente = cliente;
    }

    public Long getCodigo_venta() {
        return this.codigo_venta;
    }

    public void setCodigo_venta(Long codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public LocalDate getFecha_venta() {
        return this.fecha_venta;
    }

    
    public void setFecha_venta(LocalDate fecha_venta) {
        this.fecha_venta = fecha_venta;
    }
    
    public Double getTotal() {
        return this.total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    public List<Producto> getLista_productos() {
        return lista_productos;
    }

    public void setLista_productos(List<Producto> lista_productos) {
        this.lista_productos = lista_productos;
    }

    public Cliente getUn_cliente() {
        return un_cliente;
    }

    public void setUn_cliente(Cliente un_cliente) {
        this.un_cliente = un_cliente;
    }

}
