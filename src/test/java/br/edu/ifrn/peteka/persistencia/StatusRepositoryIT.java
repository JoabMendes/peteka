/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.PetekaApplication;
import br.edu.ifrn.peteka.dominio.Status;
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
@Test(groups = "role")
public class StatusRepositoryIT extends AbstractTestNGSpringContextTests  {

    
    @Inject
    private StatusRepository statusRepository;
    
    private final String STATUS_LABEL = "label";
    
    @BeforeMethod
    void deleteAll(){
        statusRepository.deleteAll();
        assertThat(statusRepository.findAll()).isEmpty();
    }
    
    public void repositoryNotNull () {
        assertThat(statusRepository).isNotNull();
    }
    
    
    public void testSaveOne(){
        // Creates the test environment
        Status status = Status.builder().label(this.STATUS_LABEL).build();
        
        // Saves
        this.statusRepository.save(status);
        
        // Verifies if saved
        assertThat(statusRepository.findAll().iterator().next()).isEqualTo(status);
        
    }
    
    
     public void testDeleteOne(){
        // Creates the test environment
        Status status = Status.builder().label(this.STATUS_LABEL).build();
        
        // Saves
        this.statusRepository.save(status);
        
        // Deletes
        this.statusRepository.delete(status);
        
        //Test if deleted
        assertThat(statusRepository.findOne(status.getId())).isNull();
    }
    
}
