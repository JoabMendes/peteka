/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.PetekaApplication;
import br.edu.ifrn.peteka.dominio.Task;
import javax.inject.Inject;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;


/**
 *
 * @author joab
 */
@SpringApplicationConfiguration(classes = PetekaApplication.class)
@WebAppConfiguration
@Test
public class TaskRepositoryTest extends AbstractTestNGSpringContextTests {
    
    @Inject
    private TaskRepository taskRepository;

    private static final String TASK_TITLE = "title";
    private static final String TASK_DESCRIPTION = "D1";
    
    public void testRepositoryIsNotNull(){
        assertThat(taskRepository).isNotNull();
    }
    
    public void testSaveOne(){
        // Creates the test environment
        Task task = Task.builder()
                .title(this.TASK_TITLE)
                .description(this.TASK_DESCRIPTION).build();
        
        // Saves
        this.taskRepository.save(task);
        
        // Verifies if saved
        assertThat(this.taskRepository.iterator().next()).isEqualTo(task);
        
    }
    
    
    public void testDeleteOne(){
        // Creates the test environment
        Task task = Task.builder()
                .title(this.TASK_TITLE)
                .description(this.TASK_DESCRIPTION).build();
        this.taskRepository.save(task);
        
        // Deletes
        this.taskRepository.delete(task);
        
        //Test if deleted
        assertThat(this.taskRepository.iterator().hasNext()).isFalse();
    }
    

}
