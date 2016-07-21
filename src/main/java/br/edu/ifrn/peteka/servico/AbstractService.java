/*
 * Copyright 2016-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.edu.ifrn.peteka.servico;

import java.io.Serializable;
import javax.inject.Inject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class AbstractService<T extends Object, ID extends Serializable> {

    private CrudRepository<T, ID> repository;

    @Inject
    public void setRepositorio(CrudRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Transactional
    public <S extends T> Iterable<S> save(Iterable<S> objects) {
        //Verify Business Logic
        return repository.save(objects);
    }

    @Transactional
    public <S extends T> S save(S object) {
        //Verify Business Logic
        return repository.save(object);
    }

    @Transactional
    public void delete(Iterable<? extends T> objects) {
        //Verify Business Logic
        repository.delete(objects);
    }

    @Transactional
    public void delete(ID id) {
        //Verify Business Logic
        repository.delete(id);
    }

    @Transactional
    public void delete(T object) {
        //Verify Business Logic
        repository.delete(object);
    }

    @Transactional
    public void deleteAll() {
        //Verify Business Logic
        repository.deleteAll();
    }

    public T findOne(ID id) {
        return repository.findOne(id);
    }

    public Iterable<T> findAll() {
        return repository.findAll();
    }

    public Iterable<T> findAll(Iterable<ID> ids) {
        return repository.findAll(ids);
    }

    public long count() {
        return repository.count();
    }

    public boolean exists(ID id) {
        return repository.exists(id);
    }

}
