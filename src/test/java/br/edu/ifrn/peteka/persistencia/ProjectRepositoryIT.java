/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.PetekaApplication;
import br.edu.ifrn.peteka.dominio.Project;
import br.edu.ifrn.peteka.dominio.User;
import javax.inject.Inject;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author joab
 */
@SpringApplicationConfiguration(classes = PetekaApplication.class)
@WebAppConfiguration
@Test(groups = "project")
public class ProjectRepositoryIT extends AbstractTestNGSpringContextTests {
    
    @Inject
    private ProjectRepository projectRepository;
    
    private final String PROJECT_TITLE = "title";
   private final String PROJECT_DESCRIPTION = "description";
    
    @BeforeMethod
    void deleteAll(){
        projectRepository.deleteAll();
        assertThat(projectRepository.findAll()).isEmpty();
    }
    
    public void repositoryNotNull () {
        assertThat(projectRepository).isNotNull();
    }
    
    public void deleteOne () {
        // Creates the test environment
        Project project = Project.builder()
                .title(this.PROJECT_TITLE)
                .description(this.PROJECT_DESCRIPTION).build();
        this.projectRepository.save(project);
        
        //Verify function
        this.projectRepository.delete(project);
        
        // verifica o efeito da execucao da operacao a ser testada
        assertThat(projectRepository.findOne(project.getId())).isNull();
    }
    
    public void salvarUm () {
        // Creates test environment
        Project project = Project.builder()
                .title(this.PROJECT_TITLE)
                .description(this.PROJECT_DESCRIPTION).build();
        
        // Saves
        projectRepository.save(project);
        
       // Verifies if saved
        assertThat(projectRepository.findAll().iterator().next()).isEqualTo(project);
    }
    
    public void testGetAllProjectsOfUser(){
        // Creates the test environment
        User user = User.builder()
                .nickname("Nickname")
                .name("Name").build();
        
        Project project = Project.builder()
                .title(this.PROJECT_TITLE)
                .description(this.PROJECT_DESCRIPTION).build();
        
        assertThat(projectRepository.getAllProjectsOfUser(user)
                .contains(project));
    }
 }
