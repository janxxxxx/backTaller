package TDB_PROYECT.MsAcceso.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TDB_PROYECT.MsAcceso.model.UsuarioModel;
import TDB_PROYECT.MsAcceso.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioModel{
    @Autowired
    IUsuarioRepository repository;

    @Override
    public List<UsuarioModel> findAll() {
        return (List<UsuarioModel>)repository.findAll();
    }

    @Override
    public UsuarioModel findById(Integer id) {
        return (UsuarioModel)repository.findById(id).get();
    }

    @Override
    public UsuarioModel add(UsuarioModel model) {
        return repository.save(model);
    }

    @Override
    public UsuarioModel update(UsuarioModel model) {
        return repository.save(model);
    }

    @Override
    public Boolean delete(Integer id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public String LoguearPorRol(String username, String password, Integer rol) {
        try {
            Optional<UsuarioModel> optionalUser = ((Collection<UsuarioModel>) repository.findAll())
                .stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findFirst();

            if (optionalUser.isPresent()) {
                UsuarioModel user = optionalUser.get();
                return user.getRol().equals(rol) ? "Login exitoso como " + (rol == 1 ? "Administrador" : "Básico") : "Rol incorrecto";
            } else {
                return "Usuario o contraseña incorrectos";
            }
        } catch (Exception e) {
            return "Error durante el proceso de login: " + e.getMessage();
        }
    }

    @Override
    public Boolean validarUsuario(String username) {
        try {
            return ((Collection<UsuarioModel>) repository.findAll())
                .stream()
                .anyMatch(user -> user.getUsername().equals(username));
        } catch (Exception e) {
            // Manejo de errores
            return false;
        }
    }
    
}
