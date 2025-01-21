package com.example.MsCliente.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.MsCliente.models.Clientes;

@Repository
public interface ClientesRepository extends CrudRepository<Clientes,Integer>{
    
}
