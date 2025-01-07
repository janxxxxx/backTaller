package com.example.Productos.services;

import java.util.List;

import com.example.Productos.models.Productos;

public interface IProductoServices {
    
    public List<Productos> findAll();

    public Productos findById(Integer id);

    public Productos add(Productos model);

    public Productos update(Productos model);

    public Boolean delete(Integer id);

}
