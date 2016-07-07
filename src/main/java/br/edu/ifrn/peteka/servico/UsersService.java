package br.edu.ifrn.peteka.servico;

import br.edu.ifrn.peteka.dominio.Role;
import br.edu.ifrn.peteka.dominio.Users;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import br.edu.ifrn.peteka.persistencia.UsersRepository;


@Named
public class UsersService extends AbstractService<Users, Long> {
    private UsersRepository usersRepository;

    @Inject
    public UsersService(UsersRepository userRepository) {
        super();
        this.usersRepository = userRepository;
    }
    
    public List<Users> getAllUsersOfRole(Role r) {
        return this.usersRepository.getAllUsersOfRole(r);
    }
    
    @Override
    public void save(Users obj){
        obj.verifyNickName(); //Nickname must be alphanumeric
        super.save(obj);
    }
    
}
