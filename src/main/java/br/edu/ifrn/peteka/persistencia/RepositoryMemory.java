package br.edu.ifrn.peteka.persistencia;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Created by duartemac on 2016-06-01.
 */
public class RepositoryMemory<ID extends Serializable, T> implements Repository<ID, T> {


    private HashMap<ID, T> container = new HashMap<>();

    @Override
    public void create(ID id, T object) {
        if (this.containsObject(id)) {
            throw new IllegalArgumentException();
        }
        container.put(id, object);
    }

    @Override
    public T retrieve(ID id) {
        return container.get(id);
    }

    @Override
    public void update(ID id, T object) {
        if (!this.containsObject(id)) {
            throw new NoSuchElementException();
        }
        container.put(id, object);
    }

    @Override
    public void delete(ID id) {
        if (!this.containsObject(id)) {
            throw new NoSuchElementException();
        }
        container.remove(id);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private boolean containsObject(ID id) {
        return container.containsKey(id);
    }
}
