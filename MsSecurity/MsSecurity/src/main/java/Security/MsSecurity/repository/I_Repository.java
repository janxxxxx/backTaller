package Security.MsSecurity.repository;

import org.springframework.stereotype.Repository;

import Security.MsSecurity.model.usuarios;

import org.springframework.data.repository.CrudRepository;
@Repository
public interface I_Repository extends CrudRepository<usuarios, Integer>{
    
}
