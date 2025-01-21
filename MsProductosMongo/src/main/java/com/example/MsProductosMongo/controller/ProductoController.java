package com.example.MsProductosMongo.controller;

import com.example.MsProductosMongo.model.Producto;
import com.example.MsProductosMongo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<Object> getAllProductos() {
        try {
            List<Producto> productos = productoService.getAllProductos();
            if (productos.isEmpty()) {
                return ResponseEntity.ok("Conexión exitosa, pero no se encontraron productos.");
            }
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error de conexión a la base de datos. Detalles: " + e.getMessage());
        }
    }

    // Obtener producto por código
    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<Producto> getProductoByCodigo(@PathVariable String codigo) {
        try {
            Producto producto = productoService.getProductoByCodigo(codigo);
            return ResponseEntity.ok(producto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    // Obtener producto por id (ya se maneja la conversión en el servicio)
    @GetMapping("/id/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable String id) {
        try {
            Producto producto = productoService.getProductoById(id); // No es necesario convertir a ObjectId aquí
            return producto != null ? ResponseEntity.ok(producto) : ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null); // Si el id no es válido
        }
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.createProducto(producto);
    }

    @PutMapping("/codigo/{codigo}")
    public ResponseEntity<Producto> updateProducto(@PathVariable String codigo, @RequestBody Producto producto) {
        try {
            // Buscar producto por código y luego actualizar
            Producto existingProducto = productoService.getProductoByCodigo(codigo); // Busca por código
            existingProducto.setDescripcion(producto.getDescripcion());
            existingProducto.setCategoria(producto.getCategoria());
            existingProducto.setAlmacen(producto.getAlmacen());
    
            Producto updatedProducto = productoService.updateProducto(existingProducto.getId().toString(), existingProducto); // Actualizar con ObjectId
            return ResponseEntity.ok(updatedProducto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    

@DeleteMapping("/codigo/{codigo}")
public ResponseEntity<Void> deleteProducto(@PathVariable String codigo) {
    try {
        // Buscar producto por código y eliminarlo
        productoService.deleteProducto(codigo);
        return ResponseEntity.noContent().build();
    } catch (RuntimeException e) {
        return ResponseEntity.status(404).build();
    }
}
    

}