package Clientes.Clientes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Clientes.Clientes.models.Clientes;

@Repository
public interface ClientesRepository extends CrudRepository<Clientes,Integer>{
    
}
