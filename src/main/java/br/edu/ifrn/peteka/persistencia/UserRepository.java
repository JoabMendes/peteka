package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 * Usando Query By Example
 */
public interface UserRepository extends CrudRepository<User, Long>, QueryByExampleExecutor<User> {

}
