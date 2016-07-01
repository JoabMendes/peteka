/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.Project;
import br.edu.ifrn.peteka.dominio.Status;
import br.edu.ifrn.peteka.dominio.Task;
import br.edu.ifrn.peteka.dominio.User;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author duartemac
 */
@Named
public class TaskFactory {
    // Status data
    public final static String TASK_TITLE = "title";
    public final static String TASK_DESCRIPTION = "D1";
    
    @Inject
    private TaskRepository taskRepository;
    
    @Inject
    private StatusFactory statusFactory;
    
    @Inject
    private ProjectFactory projectFactory;
    
    private Task task(String title, String description, Status st, Project p, User u) {
        
        Task task = this.taskRepository.findByTitleAndDescription(title, description);
        if (task == null) {
            task = Task.builder()
                    .title(title)
                    .description(description)
                    .status(st)
                    .project(p)
                    .assignee(u)
                    .build();

            this.taskRepository.save(task);
        }

        return task;
    }
    
    public Task task() {
        Status st = this.statusFactory.open();
        Project p = this.projectFactory.project();
        return this.task(TASK_TITLE, TASK_DESCRIPTION, st, p, null);
    }
    
    public Task task(Status st) {
        Project p = this.projectFactory.project();
        return this.task(TASK_TITLE, TASK_DESCRIPTION, st, p, null);
    }
    
    public Task task(Project p) {
        Status st = this.statusFactory.open();
        return this.task(TASK_TITLE, TASK_DESCRIPTION, st, p, null);
    }
    
    public Task task(Project p, Status st) {
        return this.task(TASK_TITLE, TASK_DESCRIPTION, st, p, null);
    }
    
    public Task task(Project p, User u) {
        Status st = this.statusFactory.open();
        return this.task(TASK_TITLE, TASK_DESCRIPTION, st, p, u);
    }
}
