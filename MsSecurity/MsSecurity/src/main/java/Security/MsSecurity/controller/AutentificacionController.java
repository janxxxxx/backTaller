package Security.MsSecurity.controller;

import java.util.List;

import org.hibernate.engine.jdbc.env.internal.LobCreationLogging_.logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Security.MsSecurity.model.usuarios;
import Security.MsSecurity.service.AutentificarUser;

public class AutentificacionController {
    @Autowired
    AutentificarUser authService;

    //@//Autowired
    //private JwtToken jwtTokenCross;

    //Logger logger = LoggerFactory.getLogger(AutentificacionController.class);

    @GetMapping
    public List<usuarios> get() {
        return authService.getAcces();
    }

    @PostMapping()
    public ResponseEntity<?> post(@RequestBody usuarios request) throws Exception {
        //logger.info("Post: Username {} - Password {}", request.getEmail(), request.getPassword());

        if (!authService.validatedCredentials(request.getEmail(), request.getPassword())) {
            return new ResponseEntity<String>("INVALID_CREDENTIALS", HttpStatus.UNAUTHORIZED);
        }

        //String token = jwtTokenCross.generateToken(request);
        //AuthResponse response = new AuthResponse(token, request.getUsername(), "1d");

        return ResponseEntity.ok(null);
    }

}
