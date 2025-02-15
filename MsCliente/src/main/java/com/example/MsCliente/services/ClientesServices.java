package com.example.MsCliente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.MsCliente.models.Clientes;
import com.example.MsCliente.repository.ClientesRepository;

@Service
public class ClientesServices implements IClientesServices{
    
    @Autowired
    ClientesRepository repository;

    @Override
    public List<Clientes> findAll() {
        return (List<Clientes>)repository.findAll();
    }

    @Override
    public Clientes findById(Integer id) {
        return (Clientes)repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + id));
    }

    @Override
    public Clientes add(Clientes model) {
        return repository.save(model);
    }

    @Override
    public Clientes update(Clientes model) {
        return repository.save(model);
    }

    @Override
    public Boolean delete(Integer id) {
        Optional<Clientes> producto = repository.findById(id);
        if (producto.isPresent()) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
