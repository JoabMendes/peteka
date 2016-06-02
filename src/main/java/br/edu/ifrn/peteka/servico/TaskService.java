package br.edu.ifrn.peteka.servico;

import br.edu.ifrn.peteka.dominio.Task;
import br.edu.ifrn.peteka.persistencia.TaskRepository;
import javax.inject.Named;
import javax.inject.Inject;

/**
 * Created by duartemac on 2016-06-01.
 */
@Named
public class TaskService extends AbstractService<Long, Task> {

    @Inject
    public TaskService(TaskRepository repository) {
        super(repository);
    }
}
