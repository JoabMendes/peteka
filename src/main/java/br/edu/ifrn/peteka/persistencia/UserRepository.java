package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>, 
        UserRepositoryCustom {
    
    //Query Method
    User findByNickname(String nickname); 
    
}
