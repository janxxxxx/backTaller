package com.example.MsCliente.services;

import java.util.List;

import com.example.MsCliente.models.Clientes;

public interface IClientesServices {

    public List<Clientes> findAll();

    public Clientes findById(Integer id);

    public Clientes add(Clientes model);

    public Clientes update(Clientes model);

    public Boolean delete(Integer id);
}