package Security.MsSecurity.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Security.MsSecurity.model.usuarios;
import Security.MsSecurity.repository.I_Repository;

@Service
public class AutentificarUser {
    @Autowired
    I_Repository authRepository;
   
    public List<usuarios>  getAcces() {
       
        return (List<usuarios>) authRepository.findAll();
    }
   
    public Boolean validatedCredentials(String UserName, String Password) {
        List<usuarios> result = (List<usuarios>) authRepository.findAll();
        List<usuarios> resultFilter = result.stream()
                .filter(t -> t.getEmail().equals(UserName) && t.getPassword().equals(Password))
                .collect(Collectors.toList());
        if (null == resultFilter || resultFilter.isEmpty()) {
            return false;
        }
        return true;
    }
}
