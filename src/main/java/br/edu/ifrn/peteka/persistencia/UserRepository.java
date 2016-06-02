package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.User;
import javax.inject.Named;

/**
 * Created by duartemac on 2016-06-01.
 */
@Named
public class UserRepository extends RepositoryMemory<Long, User> {
}
