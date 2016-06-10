/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.servico;

import br.edu.ifrn.peteka.PetekaApplication;
import br.edu.ifrn.peteka.dominio.Project;
import br.edu.ifrn.peteka.dominio.Status;
import br.edu.ifrn.peteka.dominio.Task;
import br.edu.ifrn.peteka.persistencia.DominioFactory;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.boot.test.SpringApplicationConfiguration;
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
public class TaskServiceIT extends AbstractTestNGSpringContextTests  {
    
    @Inject
    private TaskService taskService;

    @Inject
    private DominioFactory dominioFactory;
    
    @BeforeMethod
    void deleteAll()
    {
        taskService.deleteAll();
        assertThat(taskService.findAll()).isEmpty();
    }
    
    public void testServiceIsNotNull(){
        assertThat(taskService).isNotNull();
    }
    
    public void testSaveOne(){
        // Creates the test environment and save task
        Task task = dominioFactory.task();
        
        // Verifies if saved
        assertThat(this.taskService.findAll().iterator().next()).isEqualTo(task);
        
    }
    
    
    public void testDeleteOne(){
        // Creates the test environment and save task
        Task task = dominioFactory.task();
        
        // Deletes
        this.taskService.delete(task);
        
        //Test if deleted
        assertThat(this.taskService.findAll().iterator().hasNext()).isFalse();
    }
    
    public void testGetAllTasksForProject() {
        Project project = dominioFactory.project();
        // Creates the test environment and save task
        Task task = dominioFactory.task(project);
        
        assertThat(taskService.getAllTasksForProject(project)
                .contains(task));
    }
    
    public void testGetAllTasksForProjectOfStatus() {
        // Creates the test environment
        Project project = dominioFactory.project();
        Status status = dominioFactory.status();
        Task task = dominioFactory.task(project, status);
        
        assertThat(taskService.getAllTasksForProjectOfStatus(project, status)
                .contains(task));
    }
}