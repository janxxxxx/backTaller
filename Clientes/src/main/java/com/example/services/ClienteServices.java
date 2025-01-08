package main.java.com.example.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ClienteServices {

  //  List<Cliente> findAll(String palabraClave);

    //Hago otro metodo que es igual pero le paso el String y necesito castear en el Impl para devolver en el controlador
    Page<Cliente> findAll(Pageable pageable, String palabraClave);
     Page<Cliente> FindAll(Pageable pageable);

    void guardarCliente(Cliente cliente);

    Cliente buscarClienteNuevo(Long id);

    void eliminarClienteNuevo(Long id);

}
