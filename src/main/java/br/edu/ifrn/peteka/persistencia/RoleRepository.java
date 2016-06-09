package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.Role;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.QueryByExampleExecutor;


public interface RoleRepository extends CrudRepository<Role, Long> {
    
    //Query Method
    Role findByTitle(String title);
    
}
