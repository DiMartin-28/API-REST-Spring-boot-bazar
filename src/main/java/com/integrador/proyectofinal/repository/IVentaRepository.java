package com.integrador.proyectofinal.repository;

import com.integrador.proyectofinal.models.Venta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {

}
