/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.Project;
import br.edu.ifrn.peteka.dominio.QProject;
import br.edu.ifrn.peteka.dominio.User;
import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author duartemac
 */
public class ProjectRepositoryImpl implements ProjectRepositoryCustom {

    private final EntityManager entityManager;

    @Inject
    public ProjectRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public List<Project> getAllProjectsOfUser(User u) {
        QProject qProject = QProject.project;
        JPQLQueryFactory factory = new JPAQueryFactory(entityManager);

        List<Project> projects = (List<Project>) factory
                .from(qProject)
                .where(qProject.tasks.any().assignees.contains(u))
                .fetch();
        return projects;
    }
    
}
