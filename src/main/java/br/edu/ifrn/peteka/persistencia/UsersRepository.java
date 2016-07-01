package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 * Using Query By Example
 */
public interface UsersRepository extends CrudRepository<Users, Long>,QueryByExampleExecutor<Users>, UsersRepositoryCustom {
    
    //Query Method
    Users findByNickname(String nickname); 
    
}
