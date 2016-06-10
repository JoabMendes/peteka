package br.edu.ifrn.peteka.servico;

import br.edu.ifrn.peteka.dominio.Role;
import br.edu.ifrn.peteka.dominio.User;
import br.edu.ifrn.peteka.persistencia.UserRepository;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;


@Named
public class UserService extends AbstractService<User, Long> {
    private UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }
    
    public List<User> getAllUsersOfRole(Role r) {
        return this.userRepository.getAllUsersOfRole(r);
    }
}
