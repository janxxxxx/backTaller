package main.java.MsProveedores.MsProveedores.service;

import java.util.List;
import java.util.Optional;

import main.java.MsProveedores.MsProveedores.model.modelProvedor;

public interface IProvedoresService {

    public List<modelProvedor> findAll();

    Optional<modelProvedor> findById(int id);

    public modelProvedor add(modelProvedor provedor);

    public modelProvedor update(modelProvedor provedor);

    public Boolean delete(int id);

}
