package com.example.Productos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Productos.models.Productos;

@Repository
public interface ProductoRepository extends CrudRepository<Productos,Integer> {
    
}
