package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.Role;
import br.edu.ifrn.peteka.dominio.User;
import java.util.List;

/**
 *
 * @author duartemac
 */
public interface UserRepositoryCustom {
    List<User> getAllUsersOfRole(Role r);
}
