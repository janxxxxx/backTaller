package com.example.Productos.controllers;

import com.example.Productos.models.Productos;
import com.example.Productos.services.ProductoServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("productos")
public class ProductoController {
    
    @Autowired
    ProductoServices productoService;

    @GetMapping("/findAll")
    public List<Productos> FindAll()
    {
        List<Productos> lista = productoService.findAll();
        return lista;
    }

    @PostMapping("/create")
    public Productos create(@RequestBody Productos model)
    {   
        return productoService.add(model);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Productos> findById(@PathVariable Integer id) {
        try {
            Productos producto = productoService.findById(id);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Productos> update(@PathVariable Integer id, @RequestBody Productos model) {
        try {
            Productos productoExistente = productoService.findById(id);

            productoExistente.setNombre(model.getNombre());      
            productoExistente.setDescripcion(model.getDescripcion()); 
            productoExistente.setCategoria(model.getCategoria()); 
            productoExistente.setAlmacen(model.getAlmacen());   

            Productos updatedProducto = productoService.update(productoExistente);
            
            return new ResponseEntity<>(updatedProducto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        boolean isDeleted = productoService.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>("Producto eliminado con éxito", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
    }

}
