package TDB_PROYECT.MsAcceso.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

import TDB_PROYECT.MsAcceso.model.UsuarioModel;
import TDB_PROYECT.MsAcceso.repository.IBuscarUsuarioRepository;
import TDB_PROYECT.MsAcceso.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioModel{
    @Autowired
    IUsuarioRepository repository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private IBuscarUsuarioRepository buscarRepository;

     // Llave secreta (debe ser almacenada de forma segura, por ejemplo, en un servicio de gestión de claves)
     private static final String SECRET_KEY = "1234567890123456"; // 16 caracteres para AES-128


    @Override
    public List<UsuarioModel> findAll() {
        return (List<UsuarioModel>)repository.findAll();
    }

    @Override
    public UsuarioModel findById(Integer id) {
        return (UsuarioModel)repository.findById(id).get();
    }

    @Override
    public UsuarioModel add(UsuarioModel model) {
        return repository.save(model);
    }

    @Override
    public UsuarioModel update(UsuarioModel model) {
        return repository.save(model);
    }

    @Override
    public Boolean delete(Integer id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public String LoguearPorRol(String username, String password, Integer rol) {
        try {
            Optional<UsuarioModel> optionalUser = ((Collection<UsuarioModel>) repository.findAll())
                .stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findFirst();

            if (optionalUser.isPresent()) {
                UsuarioModel user = optionalUser.get();
                return user.getRol().equals(rol) ? "Login exitoso como " + (rol == 1 ? "Administrador" : "Básico") : "Rol incorrecto";
            } else {
                return "Usuario o contraseña incorrectos";
            }
        } catch (Exception e) {
            return "Error durante el proceso de login: " + e.getMessage();
        }
    }

    @Override
    public Boolean validarUsuario(String username) {
        try {
            return ((Collection<UsuarioModel>) repository.findAll())
                .stream()
                .anyMatch(user -> user.getUsername().equals(username));
        } catch (Exception e) {
            // Manejo de errores
            return false;
        }
    }

    // Metodo para encriptar la contraseña
    @Override
    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

    // Metodo para validar una contraseña contra su hash
    @Override
    public Boolean validatePassword(String password, String encodedPassword) {
        return passwordEncoder.matches(password, encodedPassword);
    }

    
    @Override
    public String encryptPassword2(String password) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(password.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    @Override
    public String decryptPassword2(String encryptPassword) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decoded = Base64.getDecoder().decode(encryptPassword);
        byte[] decrypted = cipher.doFinal(decoded);
        return new String(decrypted);
    }

    @Override
    public UsuarioModel findByNombre(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNombre'");
    }

    /* 
    @Override
    public UsuarioModel findByNombre(String nombre) {
        Optional<UsuarioModel> user = repository.findByNombre(nombre);
        return user.orElse(null); // Retorna el usuario si lo encuentra, o null si no
    }
    */
    
}
