package MsSecurity.Access.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import MsSecurity.Access.model.UsuarioModel;

@Repository
public interface IUsuarioRepository extends CrudRepository<UsuarioModel,Long>{
    
}
