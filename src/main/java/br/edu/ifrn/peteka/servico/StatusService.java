package br.edu.ifrn.peteka.servico;

import br.edu.ifrn.peteka.dominio.Status;
import br.edu.ifrn.peteka.persistencia.StatusRepository;
import javax.inject.Named;
import javax.inject.Inject;

/**
 * Created by duartemac on 2016-06-01.
 */
@Named
public class StatusService extends AbstractService<Long, Status, StatusRepository> {

    @Inject
    public StatusService(StatusRepository repository) {
        super(repository);
    }
}
