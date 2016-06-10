package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.Project;
import br.edu.ifrn.peteka.dominio.User;
import java.util.List;

/**
 *
 * @author duartemac
 */
public interface ProjectRepositoryCustom {
    List<Project> getAllProjectsOfUser(User u);
}
