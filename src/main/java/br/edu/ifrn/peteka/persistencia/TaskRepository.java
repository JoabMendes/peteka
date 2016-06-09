package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.Task;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.QueryByExampleExecutor;


public interface TaskRepository extends CrudRepository<Task, Long> {
}
