package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.Project;
import br.edu.ifrn.peteka.dominio.Status;
import br.edu.ifrn.peteka.dominio.Task;
import java.util.List;

/**
 *
 * @author duartemac
 */
public interface TaskRepositoryCustom {
    List<Task> getAllTasksForProject(Project p);
    
    List<Task> getAllTasksForProjectOfStatus(Project p, Status s);
}
