package com.example.MsProductosMongo.repository;

import com.example.MsProductosMongo.model.Producto;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface ProductoRepository extends MongoRepository<Producto, ObjectId> {

    // Método para buscar un producto por código
    Optional<Producto> findByCodigo(String codigo);
}