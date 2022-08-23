package com.integrador.proyectofinal.repository;

import com.integrador.proyectofinal.models.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {

}
