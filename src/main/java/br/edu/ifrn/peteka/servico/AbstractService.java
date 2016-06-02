package br.edu.ifrn.peteka.servico;

import br.edu.ifrn.peteka.persistencia.Repository;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Created by duartemac on 2016-06-01.
 */
public class AbstractService<ID extends Serializable, T>
        implements Service<ID, T> {

    private Repository<ID, T> repository;

    public AbstractService(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void create(ID id, T object) {
        repository.create(id, object);
    }

    @Override
    public T retrieve(ID id) {
        return repository.retrieve(id);
    }

    @Override
    public void update(ID id, T object) {
        repository.update(id, object);
    }

    @Override
    public void delete(ID id) {
        repository.delete(id);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
