package br.edu.ifrn.peteka.servico;

import br.edu.ifrn.peteka.dominio.Role;
import br.edu.ifrn.peteka.persistencia.RoleRepository;
import javax.inject.Named;
import javax.inject.Inject;

/**
 * Created by duartemac on 2016-06-01.
 */
@Named
public class RoleService extends AbstractService<Long, Role>{

    @Inject
    public RoleService(RoleRepository repository) {
        super(repository);
    }
}
