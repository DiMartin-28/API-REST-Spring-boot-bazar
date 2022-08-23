package com.integrador.proyectofinal.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidad_disponible;
    @ManyToMany(mappedBy = "lista_productos")
	private List<Venta> lista_ventas;

    public Producto() {
    }

    public Producto(Long codigo_producto, String nombre, String marca, Double costo, Double cantidad_disponible,
            List<Venta> lista_ventas) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
        this.lista_ventas = lista_ventas;
    }

    public Long getCodigo_producto() {
        return this.codigo_producto;
    }

    public void setCodigo_producto(Long codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getCosto() {
        return this.costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Double getCantidad_disponible() {
        return this.cantidad_disponible;
    }

    public void setCantidad_disponible(Double cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }
    /*
    public List<Venta> getLista_ventas() {
        return lista_ventas;
    }

    public void setLista_ventas(List<Venta> lista_ventas) {
        this.lista_ventas = lista_ventas;
    }
    */
}
