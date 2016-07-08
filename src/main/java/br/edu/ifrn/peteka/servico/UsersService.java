package br.edu.ifrn.peteka.servico;

import br.edu.ifrn.peteka.dominio.Role;
import br.edu.ifrn.peteka.dominio.Users;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import br.edu.ifrn.peteka.persistencia.UsersRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.transaction.annotation.Transactional;


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
    @Transactional
    public Users save(Users user){
        user.verifyNickName(); //Nickname must be alphanumeric
        super.save(user);
        return user;
    }
    
    @Transactional
    public Set<Users> saveAll(Set<Users> users) {
        Set<Users> savedUsers = new HashSet<> ();
        
        users.stream().map((user) -> {
            user.verifyNickName();
            return user;
        }).forEach((user) -> {
            savedUsers.add(this.usersRepository.save(user));
        });
        
        return savedUsers;
    }
    
}
