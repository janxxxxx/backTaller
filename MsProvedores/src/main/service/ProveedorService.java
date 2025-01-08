package MsProductos.MsProductos.service;

import MsProductos.MsProductos.model.Proveedor;
import MsProductos.MsProductos.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Get all proveedores
    public List<Proveedor> obtenerTodosProveedores() {
        return proveedorRepository.findAll();
    }

    // Get proveedor by id
    public Optional<Proveedor> obtenerProveedorPorId(int id) {
        return proveedorRepository.findById(id);
    }

    // Save proveedor
    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    // Delete proveedor by id
    public void eliminarProveedor(int id) {
        proveedorRepository.deleteById(id);
    }
}
