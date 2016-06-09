package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.Project;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.QueryByExampleExecutor;


public interface ProjectRepository extends CrudRepository<Project, Long> {
    
}