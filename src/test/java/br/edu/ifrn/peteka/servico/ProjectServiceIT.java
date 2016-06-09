/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.servico;

import br.edu.ifrn.peteka.PetekaApplication;
import br.edu.ifrn.peteka.dominio.Project;
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
public class ProjectServiceIT extends AbstractTestNGSpringContextTests {
    
    @Inject
    private ProjectService projectService;

    private final String PROJECT_TITLE = "title";
    private final String PROJECT_DESCRIPTION = "description";
    
    @BeforeMethod
    void deleteAll()
    {
        projectService.deleteAll();
        assertThat(projectService.findAll()).isEmpty();
    }
    
    
    public void testServiceIsNotNull(){
        assertThat(projectService).isNotNull();
    }
    
    public void testSaveOne(){
        // Creates the test environment
        Project project = Project.builder()
                .title(this.PROJECT_TITLE)
                .description(this.PROJECT_DESCRIPTION).build();
        
        // Saves
        this.projectService.save(project);
        
        // Verifies if saved
        assertThat(this.projectService.findAll().iterator().next()).isEqualTo(project);
        
    }
    
    
    public void testDeleteOne(){
        // Creates the test environment
        Project project = Project.builder()
                .title(this.PROJECT_TITLE)
                .description(this.PROJECT_DESCRIPTION).build();
        this.projectService.save(project);
        
        // Deletes
        this.projectService.delete(project);
        
        //Test if deleted
        assertThat(this.projectService.findAll().iterator().hasNext()).isFalse();
    }
    
}