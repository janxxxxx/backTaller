package TDB_PROYECT.MsAcceso.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import TDB_PROYECT.MsAcceso.model.UsuarioModel;

@Repository
public interface IUsuarioRepository extends CrudRepository<UsuarioModel, Integer>{
    //@Query("SELECT u FROM usuario u WHERE u.nombre = :nombre")
    //Optional<UsuarioModel> findByNombre(@Param("nombre") String nombre);
}
