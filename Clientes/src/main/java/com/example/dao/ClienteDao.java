package main.java.com.example.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteDao extends JpaRepository<Cliente, Long>{

    //El query no puede trabajar con la lista Page, entonces aqui creo el list
    
    @Query(value = "SELECT * FROM clientes WHERE clientes.nombre union SELECT * FROM clientes WHERE clientes.tipofactura LIKE %?1%", nativeQuery = true)
    Page<Cliente> findAll(Pageable pageable, String palabraClave);
}
