package com.example.MsProductosMongo.service;

import com.example.MsProductosMongo.model.Producto;
import com.example.MsProductosMongo.repository.ProductoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Producto getProductoByCodigo(String codigo) {
        return productoRepository.findByCodigo(codigo)
                .orElseThrow(() -> new RuntimeException("Producto con código " + codigo + " no encontrado"));
    }

    // Método actualizado para usar ObjectId con conversión de String a ObjectId
    public Producto getProductoById(String id) {
        // Convertir el String id en un ObjectId
        try {
            ObjectId objectId = new ObjectId(id);
            return productoRepository.findById(objectId)
                    .orElseThrow(() -> new RuntimeException("Producto con ID " + id + " no encontrado"));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("ID inválido: " + id);
        }
    }

    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Método para actualizar producto usando ObjectId, con validación de ID
    public Producto updateProducto(String codigo, Producto producto) {
        Producto existingProducto = productoRepository.findByCodigo(codigo)
                .orElseThrow(() -> new RuntimeException("Producto con código " + codigo + " no encontrado"));
    
        // Actualizar el producto con los nuevos valores
        existingProducto.setDescripcion(producto.getDescripcion());
        existingProducto.setCategoria(producto.getCategoria());
        existingProducto.setAlmacen(producto.getAlmacen());
    
        // Guardar el producto actualizado
        return productoRepository.save(existingProducto);
    }
    
    
    

    // Método para eliminar producto usando ObjectId
    public void deleteProducto(String codigo) {
        Producto existingProducto = productoRepository.findByCodigo(codigo)
                .orElseThrow(() -> new RuntimeException("Producto con código " + codigo + " no encontrado"));
    
        // Eliminar el producto
        productoRepository.delete(existingProducto);
    }
    
}
