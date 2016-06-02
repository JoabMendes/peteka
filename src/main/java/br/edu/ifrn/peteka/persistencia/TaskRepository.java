package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.Task;
import javax.inject.Named;

/**
 * Created by duartemac on 2016-06-01.
 */
@Named
public class TaskRepository extends RepositoryMemory<Long, Task> {
}
