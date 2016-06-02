package br.edu.ifrn.peteka.persistencia;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by duartemac on 2016-06-01.
 */
public abstract class RepositoryMemory<T> implements Repository<T> {


    private Set<T> container = new TreeSet<>();

    @Override
    public void save(T object) {
        container.add(object);
    }

    @Override
    public void delete(T object) {
        container.remove(object);
    }

    @Override
    public Iterator<T> iterator() {
        return container.iterator();
    }
}
