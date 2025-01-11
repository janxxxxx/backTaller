package MsSecurity.Access.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MsSecurity.Access.model.UsuarioModel;
import MsSecurity.Access.repository.IUsuarioRepository;

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
        return (UsuarioModel)repository.findById(id.longValue()).get();
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
        repository.deleteById(id.longValue());
        return true;
    }

    
}
