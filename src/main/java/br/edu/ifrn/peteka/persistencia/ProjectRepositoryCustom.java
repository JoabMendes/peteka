package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.Project;
import br.edu.ifrn.peteka.dominio.Users;
import java.util.List;

/**
 *
 * @author duartemac
 */
public interface ProjectRepositoryCustom {
    List<Project> getAllProjectsOfUser(Users u);
}
