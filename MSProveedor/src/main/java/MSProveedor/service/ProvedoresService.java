package MSProveedor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MSProveedor.model.modelProvedor;
import MSProveedor.repository.provedorRepository;

@Service
public class ProvedoresService implements IProvedoresService { // Usamos "Provedor" con v

    @Autowired
    private provedorRepository provedorRepository; // Usamos "Provedor" con v

    @Override
    public List<modelProvedor> findAll() {
        return (List<modelProvedor>) provedorRepository.findAll(); // Usamos "Provedor" con v
    }

    @Override
    public modelProvedor add(modelProvedor provedor) {
        return provedorRepository.save(provedor); // Usamos "Provedor" con v
    }

    @Override
    public Optional<modelProvedor> findById(int id) {
        // Devuelve el resultado del repositorio, que es un Optional<ProvedorModel>
        return provedorRepository.findById(id); // Usamos "Provedor" con v
    }

    @Override
    public modelProvedor update(modelProvedor provedor) {
        return provedorRepository.save(provedor); // Usamos "Provedor" con v
    }

    @Override
    public Boolean delete(int id) {
        provedorRepository.deleteById(id); // Usamos "Provedor" con v
        return true;
    }

}
