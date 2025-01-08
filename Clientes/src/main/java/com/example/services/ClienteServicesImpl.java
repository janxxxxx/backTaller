package main.java.com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServicesImpl implements ClienteServices {

@Autowired
ClienteDao clienteDao;

@Override
    public Page<Cliente> findAll(Pageable pageable, String palabraClave) {
        if(palabraClave != null) {
            return clienteDao.findAll(pageable, palabraClave);
        }
        return clienteDao.findAll(pageable);
    }

    @Override
    public Page<Cliente> FindAll( Pageable pageable) {

        //return clienteDao.findAll(pageable);
        return clienteDao.findAll(pageable);
    }

    @Override
    @Transactional
    public void guardarCliente(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public Cliente buscarClienteNuevo(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void eliminarClienteNuevo(Long id) {
        clienteDao.deleteById(id);
    }



}