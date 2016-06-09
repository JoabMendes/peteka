/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.servico;

import br.edu.ifrn.peteka.PetekaApplication;
import br.edu.ifrn.peteka.dominio.Status;
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
public class StatusServiceIT extends AbstractTestNGSpringContextTests {
    
    @Inject
    private StatusService statusService;
    private final String STATUS_LABEL = "label";
    
    @BeforeMethod
    void deleteAll()
    {
        statusService.deleteAll();
        assertThat(statusService.findAll()).isEmpty();
    }
    
    
    public void testServiceIsNotNull(){
        assertThat(statusService).isNotNull();
    }
    
    public void testSaveOne(){
        // Creates the test environment
        Status status = Status.builder().label(this.STATUS_LABEL).build();
        
        // Saves
        this.statusService.save(status);
        
        // Verifies if saved
        assertThat(this.statusService.findAll().iterator().next()).isEqualTo(status);
        
    }
    
    
    public void testDeleteOne(){
        // Creates the test environment
        Status status = Status.builder().label(this.STATUS_LABEL).build();
        
        // Saves
        this.statusService.save(status);
        
        // Deletes
        this.statusService.delete(status);
        
        //Test if deleted
        assertThat(this.statusService.findAll().iterator().hasNext()).isFalse();
    }
    
}


