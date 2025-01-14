package TDB_PROYECT.MsAcceso.services;

import java.util.List;

import TDB_PROYECT.MsAcceso.model.UsuarioModel;

public interface IUsuarioModel {
    public List<UsuarioModel> findAll();
    public UsuarioModel findById(Integer id);
    public UsuarioModel add(UsuarioModel model);
    public UsuarioModel update(UsuarioModel model);
    public Boolean delete(Integer id);
}
