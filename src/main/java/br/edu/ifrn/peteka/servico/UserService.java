package br.edu.ifrn.peteka.servico;

import br.edu.ifrn.peteka.dominio.User;
import br.edu.ifrn.peteka.persistencia.UserRepository;
import javax.inject.Named;
import javax.inject.Inject;

/**
 * Created by duartemac on 2016-06-01.
 */
@Named
public class UserService extends AbstractService<Long, User> {

    @Inject
    public UserService(UserRepository repository) {
        super(repository);
    }

}
