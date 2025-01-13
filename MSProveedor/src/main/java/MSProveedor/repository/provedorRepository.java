package MSProveedor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import MSProveedor.model.modelProvedor;

@Repository
public interface provedorRepository extends JpaRepository<modelProvedor, Integer> {

    Optional<modelProvedor> findById(int id); // Método para buscar por ID (proveedor_id)

    // Puedes agregar otros métodos de búsqueda personalizados si es necesario

}
