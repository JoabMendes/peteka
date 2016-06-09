package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.Status;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.QueryByExampleExecutor;


public interface StatusRepository extends CrudRepository<Status, Long> {
}
