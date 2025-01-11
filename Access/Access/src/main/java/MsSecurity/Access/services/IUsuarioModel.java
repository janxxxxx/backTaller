package MsSecurity.Access.services;

import java.util.List;

import MsSecurity.Access.model.UsuarioModel;

public interface IUsuarioModel {
    public List<UsuarioModel> findAll();
    public UsuarioModel findById(Integer id);
    public UsuarioModel add(UsuarioModel model);
    public UsuarioModel update(UsuarioModel model);
    public Boolean delete(Integer id);
}
