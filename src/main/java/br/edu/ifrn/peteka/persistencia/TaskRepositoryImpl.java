/*
 * Copyright 2016-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
