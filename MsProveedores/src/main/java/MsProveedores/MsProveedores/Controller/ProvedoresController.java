
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.example.examenparcial.endpoints.Endpoints; // Cambiar la importación aquí

import jakarta.validation.Valid;
import main.java.MsProveedores.MsProveedores.model.modelProvedor;
import main.java.MsProveedores.MsProveedores.service.ProvedoresService;

@RestController
@RequestMapping(Endpoints.BASE_PATH) // Usar la constante BASE_PATH
public class ProvedoresController {

    @Autowired
    ProvedoresService ProvedoresService; // Inyectar ProveedorService

    // Buscar todos los proveedores
    @GetMapping(Endpoints.LISTAR) // Usar la constante LISTAR
    public ResponseEntity<Map<String, Object>> findAll() {
        List<modelProvedor> lista = ProvedoresService.findAll();

        // Crear un Map para incluir el mensaje y la lista
        Map<String, Object> response = new HashMap<>();
        response.put("Lista de todos los proveedores existentes", lista);
        return ResponseEntity.ok(response);
    }

    // Crear nuevo proveedor
    @PostMapping(Endpoints.CREATE) // Usar la constante CREATE
    public ResponseEntity<String> create(@Valid @RequestBody modelProvedor model) {
        try {
            // Verificar si el proveedor ya existe por su RUC
            Optional<modelProvedor> existingProveedor = ProvedoresService.findById(model.getProveedor_id());
            if (existingProveedor.isPresent()) { // Verifica si el proveedor ya existe
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Proveedor ya existente. No se puede registrar.");
            }

            // Guardar el nuevo proveedor
            proveedorService.add(model);
            return ResponseEntity.status(HttpStatus.CREATED).body("Proveedor registrado con éxito.");

        } catch (Exception e) {
            // Manejo de excepciones generales
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear el proveedor: " + e.getMessage());
        }
    }

    // Editar un proveedor
    @PutMapping(Endpoints.UPDATE) // Usar la constante UPDATE
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody modelProvedor model) {
        try {
            modelProvedor proveedor = ProvedoresService.update(model);
            // Crear el Map para incluir el mensaje de éxito y el proveedor editado
            Map<String, Object> response = new HashMap<>();
            response.put("mensaje", "Proveedor editado con éxito");
            response.put("proveedor", proveedor);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Manejo de excepciones si algo falla
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", "Error al editar el proveedor");
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    // Buscar por ID
    @GetMapping(Endpoints.GET) // Usar la constante GET
    public ResponseEntity<modelProvedor> findById(@PathVariable int id) {
        Optional<modelProvedor> proveedorOptional = ProvedoresService.findById(id); // Cambia esto a Optional
        if (proveedorOptional.isPresent()) {
            // Si el proveedor existe, devuelve el proveedor
            return ResponseEntity.ok(proveedorOptional.get());
        } else {
            // Si el proveedor no existe, devuelve un 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un proveedor por ID
    @DeleteMapping(Endpoints.DELETE) // Usar la constante DELETE
    public ResponseEntity<String> delete(@PathVariable int id) {
        try {
            // Verificar si el proveedor existe usando Optional
            Optional<modelProvedor> proveedorOpt = ProvedoresService.findById(id);
            // Si el proveedor no existe
            if (!proveedorOpt.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Proveedor no existente. No se puede eliminar.");
            }
            // Si el proveedor existe, proceder a eliminarlo
            ProvedoresService.delete(id);

            // Retornar mensaje de éxito
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Proveedor eliminado con éxito.");
        } catch (Exception e) {
            // Manejo de excepciones generales
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el proveedor: " + e.getMessage());
        }
    }
}
