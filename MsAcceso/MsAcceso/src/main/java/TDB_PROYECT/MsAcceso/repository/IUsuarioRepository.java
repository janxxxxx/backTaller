package TDB_PROYECT.MsAcceso.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import TDB_PROYECT.MsAcceso.model.UsuarioModel;

@Repository
public interface IUsuarioRepository extends CrudRepository<UsuarioModel, Integer>{
    
}
