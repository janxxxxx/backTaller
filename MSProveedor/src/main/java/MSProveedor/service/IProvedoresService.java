package MSProveedor.service;

import java.util.List;
import java.util.Optional;

import MSProveedor.model.modelProvedor;

public interface IProvedoresService {

    public List<modelProvedor> findAll();

    Optional<modelProvedor> findById(int id);

    public modelProvedor add(modelProvedor provedor);

    public modelProvedor update(modelProvedor provedor);

    public Boolean delete(int id);

}
