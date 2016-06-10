package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.Role;
import br.edu.ifrn.peteka.dominio.User;
import java.util.Set;

/**
 *
 * @author duartemac
 */
public interface UserRepositoryCustom {
    Set<User> getAllUsersOfRole(Role r);
}
