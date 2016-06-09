package br.edu.ifrn.peteka.servico;

import java.io.Serializable;
import javax.inject.Inject;
import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;


public class AbstractService<T extends Object, ID extends Serializable> {

    private CrudRepository<T, ID> repository;

    @Inject
    public void setRepositorio(CrudRepository<T, ID> repository) {
        this.repository = repository;
    }

    public void save(T object) {
        //Verify Business Logic
        repository.save(object);
    }
    
    
    public void delete(T object) {
        //Verify Business Logic
        repository.delete(object);
    }
    
    public Iterable<T> findAll() {
        return repository.findAll();
    }


    public void deleteAll() {
        //Verify Business Logic
        repository.deleteAll();
    }
}
