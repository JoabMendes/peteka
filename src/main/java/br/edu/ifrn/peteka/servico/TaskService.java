package br.edu.ifrn.peteka.servico;

import br.edu.ifrn.peteka.dominio.Project;
import br.edu.ifrn.peteka.dominio.Status;
import br.edu.ifrn.peteka.dominio.Task;
import br.edu.ifrn.peteka.persistencia.TaskRepository;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;


@Named
public class TaskService extends AbstractService<Task, Long> {
    private TaskRepository taskRepository;

    @Inject
    public TaskService(TaskRepository taskRepository) {
        super();
        this.taskRepository = taskRepository;
    }
    
    public List<Task> getAllTasksForProject(Project p) {
        return this.taskRepository.getAllTasksForProject(p);
    }
    
    public List<Task> getAllTasksForProjectOfStatus(Project p, Status s) {
        return this.taskRepository.getAllTasksForProjectOfStatus(p, s);
    }
}
