package MsSecurity.Access.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import MsSecurity.Access.constanst.NoHardCodeo;
import MsSecurity.Access.model.UsuarioModel;
import MsSecurity.Access.repository.IUsuarioRepository;
import MsSecurity.Access.services.UsuarioService;

@RestController
@RequestMapping(NoHardCodeo.ALUMNO_BASE)
public class UsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    UsuarioService usuarioService;

    @GetMapping(NoHardCodeo.GET_ALL)
    public List<UsuarioModel> findAll() {
        try {
            List<UsuarioModel> lista = usuarioService.findAll();
            return lista;
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al obtener la lista de alumnos: {}", e.getMessage(), e);
            return new ArrayList<>(); // Retornar lista vacía en caso de error
        } finally {
            // Usamos el logger para informar que el metodo se ejecuto
            logger.info("Metodo findAll ejecutado");
        }
    }

    @PostMapping(NoHardCodeo.CREATE)
    public UsuarioModel create(@RequestBody UsuarioModel model) {
        try {
            return usuarioService.add(model);
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al crear el alumno: {}", e.getMessage(), e);
            return null; // Retornar nulo en caso de error
        } finally {
            // Usamos el logger para informar que el metodo se ejecuto
            logger.info("Metodo create ejecutado");
        }
    }

    @GetMapping(NoHardCodeo.GET_BY_ID)
    public AlumnoModel findById(@PathVariable Integer id) {
        try {
            return alumnoService.findById(id);
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al buscar el alumno con ID {}: {}", id, e.getMessage(), e);
            return null; // Retornar nulo en caso de error
        } finally {
            // Usamos el logger para informar que el método se ejecutó
            logger.info("Metodo findById ejecutado");
        }
    }

    @PutMapping(NoHardCodeo.UPDATE)
    public AlumnoModel update(@RequestBody AlumnoModel model) {
        try {
            return alumnoService.update(model);
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al actualizar el alumno: {}", e.getMessage(), e);
            return null; // Retornar nulo en caso de error
        } finally {
            // Usamos el logger para informar que el método se ejecutó
            logger.info("Metodo update ejecutado");
        }
    }

    @DeleteMapping(NoHardCodeo.DELETE)
    public String delete(@PathVariable Integer id) {
        try {
            boolean isDeleted = alumnoService.delete(id);
            return isDeleted ? "Usuario eliminado correctamente" : "Error al eliminar usuario";
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al eliminar el alumno con ID {}: {}", id, e.getMessage(), e);
            return "Ocurrio un error al intentar eliminar el usuario.";
        } finally {
            // Usamos el logger para informar que el método se ejecutó
            logger.info("Metodo delete ejecutado.");
        }
    }
}
