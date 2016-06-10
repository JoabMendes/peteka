package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.Project;
import br.edu.ifrn.peteka.dominio.QTask;
import br.edu.ifrn.peteka.dominio.Status;
import br.edu.ifrn.peteka.dominio.Task;
import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author duartemac
 */
public class TaskRepositoryImpl implements TaskRepositoryCustom {
    
    private final EntityManager entityManager;

    @Inject
    public TaskRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public List<Task> getAllTasksForProject(Project p) {
        QTask qTask = QTask.task;
        JPQLQueryFactory factory = new JPAQueryFactory(entityManager);

        List<Task> tasks = (List<Task>) factory
                .from(qTask)
                .where(qTask.project.eq(p))
                .fetch();
        return tasks;
    }

    @Override
    public List<Task> getAllTasksForProjectOfStatus(Project p, Status s) {
        QTask qTask = QTask.task;
        JPQLQueryFactory factory = new JPAQueryFactory(entityManager);

        List<Task> tasks = (List<Task>) factory
                .from(qTask)
                .where(qTask.project.eq(p).and(qTask.status.eq(s)))
                .fetch();
        return tasks;
    }
    
    
}
