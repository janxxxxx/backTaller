package MsProductos.MsProductos.controller;

import MsProductos.MsProductos.model.Proveedor;
import MsProductos.MsProductos.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    // Get all proveedores
    @GetMapping
    public List<Proveedor> obtenerTodosProveedores() {
        return proveedorService.obtenerTodosProveedores();
    }

    // Get proveedor by id
    @GetMapping("/{id}")
    public Optional<Proveedor> obtenerProveedorPorId(@PathVariable int id) {
        return proveedorService.obtenerProveedorPorId(id);
    }

    // Save a new proveedor
    @PostMapping
    public Proveedor guardarProveedor(@RequestBody Proveedor proveedor) {
        return proveedorService.guardarProveedor(proveedor);
    }

    // Delete proveedor by id
    @DeleteMapping("/{id}")
    public void eliminarProveedor(@PathVariable int id) {
        proveedorService.eliminarProveedor(id);
    }
}

