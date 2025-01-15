package Clientes.Clientes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Clientes.Clientes.models.Clientes;
import Clientes.Clientes.services.ClientesServices;

@RestController
@RequestMapping("clientes")
public class ClientesController {
    
    @Autowired
    ClientesServices clientesServices;

    @GetMapping("/findAll")
    public List<Clientes> FindAll()
    {
        List<Clientes> lista = clientesServices.findAll();
        return lista;
    }

    @PostMapping("/create")
    public Clientes create(@RequestBody Clientes model)
    {   
        return clientesServices.add(model);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> findById(@PathVariable Integer id) {
        try {
            Clientes clientes = clientesServices.findById(id);
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clientes> update(@PathVariable Integer id, @RequestBody Clientes model) {
        try {
            Clientes clientesExistente = clientesServices.findById(id);

            clientesExistente.setNombres(model.getNombres());    
            clientesExistente.setApellidos(model.getApellidos()); 
            clientesExistente.setEmail(model.getEmail());
            clientesExistente.setFecha(model.getFecha());
            clientesExistente.setDescripcion(model.getDescripcion()); 
            clientesExistente.setNumtelef(model.getNumtelef()); 
            clientesExistente.setTipofactura(model.getTipofactura());   

            Clientes updatedClientes = clientesServices.update(clientesExistente);
            
            return new ResponseEntity<>(updatedClientes, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        boolean isDeleted = clientesServices.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>("Cliente eliminado con éxito", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
        }
    }

}