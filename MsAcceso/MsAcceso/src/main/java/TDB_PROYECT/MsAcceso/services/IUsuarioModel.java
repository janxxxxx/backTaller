package TDB_PROYECT.MsAcceso.services;

import java.util.List;

import TDB_PROYECT.MsAcceso.model.UsuarioModel;

public interface IUsuarioModel {
    public List<UsuarioModel> findAll();
    public UsuarioModel findById(Integer id);
    public UsuarioModel add(UsuarioModel model);
    public UsuarioModel update(UsuarioModel model);
    public Boolean delete(Integer id);
    public String LoguearPorRol(String  username, String password,Integer rol );
    public Boolean validarUsuario(String username);
    public String encryptPassword(String password);
    public Boolean validatePassword(String password, String encodedPassword);
    public String encryptPassword2(String password) throws Exception;
    public String decryptPassword2(String encryptPassword) throws Exception;
    public UsuarioModel findByNombre(String nombre);
}
