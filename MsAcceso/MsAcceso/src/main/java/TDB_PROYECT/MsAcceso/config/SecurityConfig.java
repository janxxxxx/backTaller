package TDB_PROYECT.MsAcceso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    //Este metodo es para habilitar permiso de credenciales
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Nueva forma de desactivar CSRF
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/encrypt-password", "/validate-password").permitAll() // Permite estas rutas
                .anyRequest().authenticated() // Todas las demás requieren autenticación
            )
            .httpBasic(withDefaults()); // Habilita autenticación básica (opcional para pruebas)
        return http.build();
    }
}
