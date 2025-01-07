package Security.MsSecurity.service;

import java.util.Optional;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Security.MsSecurity.model.User;
import Security.MsSecurity.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;  // El repositorio de usuarios

    @Autowired
    private PasswordEncoder passwordEncoder;  // Inyectamos el PasswordEncoder

    // Método para encontrar un usuario por su nombre de usuario
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Método para guardar un usuario con la contraseña encriptada
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));  // Encriptamos la contraseña
        return userRepository.save(user);  // Guardamos el usuario en la base de datos
    }
}

