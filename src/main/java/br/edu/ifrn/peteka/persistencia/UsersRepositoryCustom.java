package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.Role;
import br.edu.ifrn.peteka.dominio.Users;
import java.util.List;

/**
 *
 * @author duartemac
 */
public interface UsersRepositoryCustom {
    List<Users> getAllUsersOfRole(Role r);
}
