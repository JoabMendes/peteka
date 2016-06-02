package br.edu.ifrn.peteka.servico;

import br.edu.ifrn.peteka.persistencia.Repository;

import java.util.Iterator;

/**
 * Created by duartemac on 2016-06-01.
 */
public abstract class AbstractService<T> implements Service<T> {

    private Repository<T> repository;

    public AbstractService(Repository<T> repository) {
        this.repository = repository;
    }

    @Override
    public void save(T object) {
        repository.save(object);
    }

    @Override
    public void delete(T object) {
        repository.delete(object);
    }

    @Override
    public Iterator<T> iterator() {
        return repository.iterator();
    }
}
