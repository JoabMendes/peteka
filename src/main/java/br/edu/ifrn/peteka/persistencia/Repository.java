package br.edu.ifrn.peteka.persistencia;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Created by duartemac on 2016-06-01.
 */
public interface Repository<T> {

    void save(T object);

    void delete(T object);

    Iterator<T> iterator();
}
