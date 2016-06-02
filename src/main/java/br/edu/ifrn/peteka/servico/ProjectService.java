package br.edu.ifrn.peteka.servico;

import br.edu.ifrn.peteka.dominio.Project;
import br.edu.ifrn.peteka.persistencia.ProjectRepository;
import javax.inject.Named;
import javax.inject.Inject;

/**
 * Created by duartemac on 2016-06-01.
 */
@Named
public class ProjectService extends AbstractService<Project> {

    @Inject
    public ProjectService(ProjectRepository repository) {
        super(repository);
    }
}
