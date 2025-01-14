package TDB_PROYECT.MsAcceso.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import TDB_PROYECT.MsAcceso.constanst.NoHardCodeo;
import TDB_PROYECT.MsAcceso.model.UsuarioModel;
import TDB_PROYECT.MsAcceso.services.UsuarioService;

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
            System.out.println("\n             Entrando al listado                \n");
            return lista;
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al obtener la lista de usuarios: {}", e.getMessage(), e);
            System.out.println("\n             retorna lista vacia                \n");
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
            logger.error("Error al crear el usuario: {}", e.getMessage(), e);
            return null; // Retornar nulo en caso de error
        } finally {
            // Usamos el logger para informar que el metodo se ejecuto
            logger.info("Metodo create ejecutado");
        }
    }

    @GetMapping(NoHardCodeo.GET_BY_ID)
    public UsuarioModel findById(@PathVariable Integer id) {
        try {
            return usuarioService.findById(id);
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al buscar el usuario con ID {}: {}", id, e.getMessage(), e);
            return null; // Retornar nulo en caso de error
        } finally {
            // Usamos el logger para informar que el método se ejecutó
            logger.info("Metodo findById ejecutado");
        }
    }

    @PutMapping(NoHardCodeo.UPDATE)
    public UsuarioModel update(@RequestBody UsuarioModel model) {
        try {
            return usuarioService.update(model);
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al actualizar el usuario: {}", e.getMessage(), e);
            return null; // Retornar nulo en caso de error
        } finally {
            // Usamos el logger para informar que el método se ejecutó
            logger.info("Metodo update ejecutado");
        }
    }

    @DeleteMapping(NoHardCodeo.DELETE)
    public String delete(@PathVariable Integer id) {
        try {
            boolean isDeleted = usuarioService.delete(id);
            return isDeleted ? "Usuario eliminado correctamente" : "Error al eliminar usuario";
        } catch (Exception e) {
            // Usamos el logger para registrar el error
            logger.error("Error al eliminar el usuario con ID {}: {}", id, e.getMessage(), e);
            return "Ocurrio un error al intentar eliminar el usuario.";
        } finally {
            // Usamos el logger para informar que el método se ejecutó
            logger.info("Metodo delete ejecutado.");
        }
    }

    @PostMapping("/login-por-role")
    public String loginWithRole(@RequestBody Map<String, Object> loginRequest) {
        try {
            String username = (String) loginRequest.get("username");
            String password = (String) loginRequest.get("password");
            Integer rol = (Integer) loginRequest.get("rol");

            return usuarioService.LoguearPorRol(username,password,rol);
        } catch (Exception e) {
            logger.error("Error al intentar loguear al usuario: {}", e.getMessage(), e);
            return "Error en la solicitud de login";
        } finally {
            logger.info("Metodo loginWithRole ejecutado");
        }
    }

    @GetMapping("/existe/{username}")
    public String checkUserExists(@PathVariable String username) {
        try {
            boolean exists = usuarioService.validarUsuario(username);
            return exists ? "El usuario existe" : "El usuario no existe";
        } catch (Exception e) {
            logger.error("Error al validar la existencia del usuario: {}", e.getMessage(), e);
            return "Error al verificar la existencia del usuario";
        } finally {
            logger.info("Método checkUserExists ejecutado");
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody UsuarioModel loginRequest) {
        UsuarioModel user = usuarioService.findById(loginRequest.getIdUsuario());
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            return "Login exitoso"; // Puedes redirigir o responder según tu lógica
        }
        return "Credenciales inválidas";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "index.html"; // Nombre del archivo HTML sin la extensión
    }
}
