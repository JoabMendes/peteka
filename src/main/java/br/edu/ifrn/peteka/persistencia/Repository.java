package br.edu.ifrn.peteka.persistencia;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Created by duartemac on 2016-06-01.
 */
public interface Repository<ID extends Serializable, T> {

    void create(ID id, T object);

    T retrieve(ID id);

    void update(ID id, T object);

    void delete(ID id);

    Iterator<T> iterator();
}
