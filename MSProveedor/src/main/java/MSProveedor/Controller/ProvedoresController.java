package MSProveedor.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import MSProveedor.endpoints.Endpoints;
import MSProveedor.model.modelProvedor;
import MSProveedor.service.ProvedoresService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(Endpoints.BASE_PATH) // Usar la constante BASE_PATH
public class ProvedoresController {

    private static final Logger logger = LoggerFactory.getLogger(ProvedoresController.class);

    @Autowired
    ProvedoresService ProvedoresService;

    // Buscar todos los proveedores
    @GetMapping(Endpoints.LISTAR)
    public ResponseEntity<Map<String, Object>> findAll() {
        logger.info("Iniciando búsqueda de todos los proveedores");
        List<modelProvedor> lista = ProvedoresService.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("Lista de todos los proveedores existentes", lista);
        logger.info("Se encontraron {} proveedores", lista.size());
        return ResponseEntity.ok(response);
    }

    // Crear nuevo proveedor
    @PostMapping(Endpoints.CREATE)
    public ResponseEntity<String> create(@Valid @RequestBody modelProvedor model) {
        logger.info("Iniciando creación de un nuevo proveedor con ID: {}", model.getProveedor_id());
        try {
            Optional<modelProvedor> existingProveedor = ProvedoresService.findById(model.getProveedor_id());
            if (existingProveedor.isPresent()) {
                logger.warn("El proveedor con ID: {} ya existe", model.getProveedor_id());
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Proveedor ya existente. No se puede registrar.");
            }
            ProvedoresService.add(model);
            logger.info("Proveedor con ID: {} registrado con éxito", model.getProveedor_id());
            return ResponseEntity.status(HttpStatus.CREATED).body("Proveedor registrado con éxito.");
        } catch (Exception e) {
            logger.error("Error al crear el proveedor: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear el proveedor: " + e.getMessage());
        }
    }

    // Editar un proveedor
    @PutMapping(Endpoints.UPDATE)
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody modelProvedor model) {
        logger.info("Iniciando edición del proveedor con ID: {}", model.getProveedor_id());
        Map<String, Object> response = new HashMap<>();
        try {
            // Verifica que el ID no sea nulo
            if (model.getProveedor_id() == null) {
                response.put("mensaje", "El ID del proveedor es obligatorio.");
                return ResponseEntity.badRequest().body(response);
            }

            // Llama al servicio para actualizar el proveedor
            modelProvedor proveedor = ProvedoresService.update(model);

            response.put("mensaje", "Proveedor editado con éxito");
            response.put("proveedor", proveedor);
            logger.info("Proveedor con ID: {} editado con éxito", model.getProveedor_id());
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            logger.error("Error al editar el proveedor - ID inválido: {}", model.getProveedor_id(), e);
            response.put("mensaje", "Error: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        } catch (RuntimeException e) {
            logger.error("Error al editar el proveedor - No encontrado: {}", model.getProveedor_id(), e);
            response.put("mensaje", "Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } catch (Exception e) {
            logger.error("Error inesperado al editar el proveedor con ID: {}", model.getProveedor_id(), e);
            response.put("mensaje", "Error inesperado al editar el proveedor.");
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // Buscar por ID con caché
    @GetMapping(Endpoints.GET)
    public ResponseEntity<modelProvedor> findById(@PathVariable int id) {
        logger.info("Buscando proveedor con ID: {}", id);
        Optional<modelProvedor> proveedorOptional = ProvedoresService.findProveedorById(id); // Usa el método con
                                                                                             // @Cacheable
        if (proveedorOptional.isPresent()) {
            logger.info("Proveedor con ID: {} encontrado", id);
            return ResponseEntity.ok(proveedorOptional.get());
        } else {
            logger.warn("Proveedor con ID: {} no encontrado", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un proveedor por ID
    @DeleteMapping(Endpoints.DELETE)
    public ResponseEntity<String> delete(@PathVariable int id) {
        logger.info("Iniciando eliminación del proveedor con ID: {}", id);
        try {
            Optional<modelProvedor> proveedorOpt = ProvedoresService.findById(id);
            if (!proveedorOpt.isPresent()) {
                logger.warn("Proveedor con ID: {} no encontrado para eliminar", id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Proveedor no existente. No se puede eliminar.");
            }
            ProvedoresService.delete(id); // Elimina la caché correspondiente con @CacheEvict
            logger.info("Proveedor con ID: {} eliminado con éxito", id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Proveedor eliminado con éxito.");
        } catch (Exception e) {
            logger.error("Error al eliminar el proveedor con ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el proveedor: " + e.getMessage());
        }
    }
}
