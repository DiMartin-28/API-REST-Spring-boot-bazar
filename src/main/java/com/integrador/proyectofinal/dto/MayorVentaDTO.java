package com.integrador.proyectofinal.dto;

public class MayorVentaDTO {
    private Long codigo_venta;
    private Double total;
    private int cant_productos;
    private String nomb_cliente;
    private String ape_cliente;

    public MayorVentaDTO() {
    }

    public MayorVentaDTO(Long codigo_venta, Double total, int cant_productos, String nomb_cliente, String ape_cliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cant_productos = cant_productos;
        this.nomb_cliente = nomb_cliente;
        this.ape_cliente = ape_cliente;
    }

    public Long getCodigo_venta() {
        return codigo_venta;
    }

    public void setCodigo_venta(Long codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getCant_productos() {
        return cant_productos;
    }

    public void setCant_productos(int cant_productos) {
        this.cant_productos = cant_productos;
    }

    public String getNomb_cliente() {
        return nomb_cliente;
    }

    public void setNomb_cliente(String nomb_cliente) {
        this.nomb_cliente = nomb_cliente;
    }

    public String getApe_cliente() {
        return ape_cliente;
    }

    public void setApe_cliente(String ape_cliente) {
        this.ape_cliente = ape_cliente;
    }
}
