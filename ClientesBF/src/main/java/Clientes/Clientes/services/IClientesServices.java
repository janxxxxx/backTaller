package Clientes.Clientes.services;

import Clientes.Clientes.models.Clientes;
import java.util.List;

public interface IClientesServices {

    public List<Clientes> findAll();

    public Clientes findById(Integer id);

    public Clientes add(Clientes model);

    public Clientes update(Clientes model);

    public Boolean delete(Integer id);
}
