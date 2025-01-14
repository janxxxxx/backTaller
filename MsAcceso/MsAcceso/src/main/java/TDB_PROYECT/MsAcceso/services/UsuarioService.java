package TDB_PROYECT.MsAcceso.services;

import java.util.List;

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
    
}
