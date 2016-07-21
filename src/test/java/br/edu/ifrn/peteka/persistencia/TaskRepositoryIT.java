/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.PetekaApplication;
import br.edu.ifrn.peteka.dominio.Project;
import br.edu.ifrn.peteka.dominio.Status;
import br.edu.ifrn.peteka.dominio.Task;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Example;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author joab
 */
@SpringApplicationConfiguration(classes = PetekaApplication.class)
@WebAppConfiguration
@Test(groups = "task", dependsOnGroups = {"project", "status"})
public class TaskRepositoryIT extends AbstractTestNGSpringContextTests {

    @Inject
    private TaskRepository taskRepository;

    @Inject
    private TaskFactory taskFactory;

    @Inject
    private StatusFactory statusFactory;

    @Inject
    private ProjectFactory projectFactory;

    @BeforeMethod
    void deleteAll() {
        taskRepository.deleteAll();
        assertThat(taskRepository.findAll()).isEmpty();
    }

    public void testRepositoryIsNotNull() {
        assertThat(taskRepository).isNotNull();
    }

    public void testSaveOne() {
        // Creates the test environment and save task
        Task task = taskFactory.task();

        // Verifies if saved
        assertThat(taskRepository.findAll().iterator().next()).isEqualTo(task);

    }

    public void testDeleteOne() {
        // Creates the test environment and save task
        Task task = taskFactory.task();

        // Deletes
        this.taskRepository.delete(task);

        //Test if deleted
        assertThat(taskRepository.findOne(task.getId())).isNull();
    }

    // query by example, test do not apply
    /*public void testDeleteByStatus(){
    
        // Creates the test environment and save status
        Status status = dominioFactory.status();
        
        // Creates the test environment and save task
        Task task = dominioFactory.task();

        assertThat(this.taskRepository.findAll()).isNotEmpty();
        
        this.taskRepository.deleteByStatus(status);
        
        assertThat(this.taskRepository.findAll()).isNotEmpty();
        
    }*/
    public void findAllByExample() {
        // Creates the test environment and save status
        Status st = statusFactory.open();

        // Creates the test environment and save task
        Task task = taskFactory.task(st);

        // Creates the test environment and save task
        Task taskExample = taskFactory.task();

        assertThat(this.taskRepository
                .findAll(Example.of(taskExample)).iterator().next())
                .isEqualTo(task);
    }

    public void testGetAllTasksForProject() {
        Project project = projectFactory.project();
        // Creates the test environment and save task
        Task task = taskFactory.task(project);

        assertThat(taskRepository.getAllTasksForProject(project)
                .contains(task));
    }

    public void testGetAllTasksForProjectOfStatus() {
        // Creates the test environment
        Project project = projectFactory.project();
        Status status = statusFactory.open();
        Task task = taskFactory.task(project, status);

        assertThat(taskRepository.getAllTasksForProjectOfStatus(project, status)
                .contains(task));
    }

}
