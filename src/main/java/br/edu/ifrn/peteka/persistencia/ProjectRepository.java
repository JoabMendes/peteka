package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.Project;
import javax.inject.Named;

/**
 * Created by duartemac on 2016-06-01.
 */
@Named
public class ProjectRepository extends RepositoryMemory<Long, Project> {
}
