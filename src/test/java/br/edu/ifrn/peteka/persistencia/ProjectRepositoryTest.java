/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.PetekaApplication;
import br.edu.ifrn.peteka.dominio.Project;
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
public class ProjectRepositoryTest extends AbstractTestNGSpringContextTests{
    
    @Inject
    private ProjectRepository projectRepository;

    private final String PROJECT_TITLE = "title";
    private final String PROJECT_DESCRIPTION = "description";
    
    public void testRepositoryIsNotNull(){
        assertThat(projectRepository).isNotNull();
    }
    
    public void testSaveOne(){
        // Creates the test environment
        Project project = Project.builder()
                .title(this.PROJECT_TITLE)
                .description(this.PROJECT_DESCRIPTION).build();
        
        // Saves
        this.projectRepository.save(project);
        
        // Verifies if saved
        assertThat(this.projectRepository.iterator().next()).isEqualTo(project);
        
    }
    
    
    public void testDeleteOne(){
        // Creates the test environment
        Project project = Project.builder()
                .title(this.PROJECT_TITLE)
                .description(this.PROJECT_DESCRIPTION).build();
        this.projectRepository.save(project);
        
        // Deletes
        this.projectRepository.delete(project);
        
        //Test if deleted
        assertThat(this.projectRepository.iterator().hasNext()).isFalse();
    }
    
    
}
