package TDB_PROYECT.MsAcceso.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import TDB_PROYECT.MsAcceso.model.UsuarioModel;

public interface IBuscarUsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
    //@Query("SELECT u FROM usuario u WHERE u.nombre = :nombre")
    //Optional<UsuarioModel> findByNombre(@Param("nombre") String nombre);
}
