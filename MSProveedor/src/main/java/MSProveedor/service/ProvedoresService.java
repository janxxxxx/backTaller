package MSProveedor.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import MSProveedor.model.modelProvedor;
import MSProveedor.repository.provedorRepository;

@Service
@CacheConfig(cacheNames = "proveedores") // Define el nombre de la caché
public class ProvedoresService implements IProvedoresService {

    private static final Logger logger = LoggerFactory.getLogger(ProvedoresService.class); // Define un logger

    @Autowired
    private provedorRepository provedorRepository;

    @Override
    public List<modelProvedor> findAll() {
        return (List<modelProvedor>) provedorRepository.findAll();
    }

    @Override
    public modelProvedor add(modelProvedor provedor) {
        return provedorRepository.save(provedor);
    }

    @Override
    public Optional<modelProvedor> findById(int id) {
        return provedorRepository.findById(id);
    }

    @Override
    public modelProvedor update(modelProvedor provedor) {
        if (provedor.getProveedor_id() == null) {
            throw new IllegalArgumentException("El ID del proveedor es obligatorio para actualizar.");
        }

        Optional<modelProvedor> existingProveedor = provedorRepository.findById(provedor.getProveedor_id());
        if (!existingProveedor.isPresent()) {
            throw new RuntimeException("El proveedor con ID " + provedor.getProveedor_id() + " no existe.");
        }

        modelProvedor proveedorToUpdate = existingProveedor.get();
        proveedorToUpdate.setRuc_proveedor(provedor.getRuc_proveedor());
        proveedorToUpdate.setNombre_proveedor(provedor.getNombre_proveedor());
        proveedorToUpdate.setCorreo_proveedor(provedor.getCorreo_proveedor());
        proveedorToUpdate.setTelefono_proveedor(provedor.getTelefono_proveedor());
        proveedorToUpdate.setDireccion_proveedor(provedor.getDireccion_proveedor());
        proveedorToUpdate.setEstado_proveedor(provedor.getEstado_proveedor());

        return provedorRepository.save(proveedorToUpdate);
    }

    @Override
    public Boolean delete(int id) {
        provedorRepository.deleteById(id);
        return true;
    }

    @Override
    @Cacheable(key = "#id") // Configura la caché para este método
    public Optional<modelProvedor> findProveedorById(Integer id) {
        logger.info("SERVICE: Get Find By id: {}", id);
        return provedorRepository.findById(id); // Consulta en el repositorio
    }
}
