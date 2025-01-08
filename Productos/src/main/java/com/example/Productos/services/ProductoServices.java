package com.example.Productos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Productos.repository.ProductoRepository;
import java.util.List;
import java.util.Optional;

import com.example.Productos.models.Productos;

@Service
public class ProductoServices implements IProductoServices{

    @Autowired
    ProductoRepository repository;

    @Override
    public List<Productos> findAll() {
        return (List<Productos>)repository.findAll();
    }

    @Override
    public Productos findById(Integer id) {
        return (Productos)repository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
    }

    @Override
    public Productos add(Productos model) {
        return repository.save(model);
    }

    @Override
    public Productos update(Productos model) {
        return repository.save(model);
    }

    @Override
    public Boolean delete(Integer id) {
        Optional<Productos> producto = repository.findById(id);
        if (producto.isPresent()) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
