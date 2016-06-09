/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.servico;

import br.edu.ifrn.peteka.PetekaApplication;
import br.edu.ifrn.peteka.dominio.Task;
import javax.inject.Inject;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author joab
 */
@SpringApplicationConfiguration(classes = PetekaApplication.class)
@WebAppConfiguration
@Test
public class TaskServiceIT extends AbstractTestNGSpringContextTests  {
    
    @Inject
    private TaskService taskService;

    private final String TASK_TITLE = "title";
    private final String TASK_DESCRIPTION = "D1";
    
    
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
        // Creates the test environment
        Task task = Task.builder()
                .title(this.TASK_TITLE)
                .description(this.TASK_DESCRIPTION).build();
        
        // Saves
        this.taskService.save(task);
        
        // Verifies if saved
        assertThat(this.taskService.findAll().iterator().next()).isEqualTo(task);
        
    }
    
    
    public void testDeleteOne(){
        // Creates the test environment
        Task task = Task.builder()
                .title(this.TASK_TITLE)
                .description(this.TASK_DESCRIPTION).build();
        this.taskService.save(task);
        
        // Deletes
        this.taskService.delete(task);
        
        //Test if deleted
        assertThat(this.taskService.findAll().iterator().hasNext()).isFalse();
    }
    
    
}