package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.Project;
import br.edu.ifrn.peteka.dominio.Status;
import br.edu.ifrn.peteka.dominio.Task;
import java.util.Set;

/**
 *
 * @author duartemac
 */
public interface TaskRepositoryCustom {
    Set<Task> getAllTasksForProject(Project p);
    
    Set<Task> getAllTasksForProjectOfStatus(Project p, Status s);
}
