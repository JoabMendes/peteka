/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.servico;

import br.edu.ifrn.peteka.PetekaApplication;
import br.edu.ifrn.peteka.dominio.Project;
import br.edu.ifrn.peteka.dominio.Task;
import br.edu.ifrn.peteka.dominio.User;
import br.edu.ifrn.peteka.persistencia.ProjectFactory;
import br.edu.ifrn.peteka.persistencia.TaskFactory;
import br.edu.ifrn.peteka.persistencia.UserFactory;
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
@Test(groups = "project")
public class ProjectServiceIT extends AbstractTestNGSpringContextTests {
    
    @Inject
    private ProjectService projectService;
    @Inject
    private TaskService taskService;
    @Inject
    private ProjectFactory projectFactory;
    @Inject
    private UserFactory userFactory;
    @Inject
    private TaskFactory taskFactory;
    
    @BeforeMethod
    void deleteAll()
    {
        taskService.deleteAll();
        projectService.deleteAll();
        assertThat(projectService.findAll()).isEmpty();
    }
    
    
    public void testServiceIsNotNull(){
        assertThat(projectService).isNotNull();
    }
    
    public void testSaveOne(){
        // Creates the test environment and save it
        Project project = projectFactory.project();
        
        // Verifies if saved
        assertThat(this.projectService.findAll().iterator().next())
                .isEqualTo(project);   
    }
    
    
    public void testDeleteOne(){
        // Creates the test environment and save it
        Project project = projectFactory.project();
        
        // Deletes
        this.projectService.delete(project);
        
        //Test if deleted
        assertThat(this.projectService.findAll().iterator().hasNext()).isFalse();
    }
    
    public void testGetAllProjectsOfUser(){
        // Creates the test environment
        User user = userFactory.fred();
        
        Project project = projectFactory.project();
        
        taskFactory.task(project, user);
        
        assertThat(projectService.getAllProjectsOfUser(user)
                .contains(project));
    }
    
}