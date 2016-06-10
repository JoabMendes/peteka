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
import org.springframework.web.method.annotation.ModelFactory;

/**
 *
 * @author joab
 */
@SpringApplicationConfiguration(classes = PetekaApplication.class)
@WebAppConfiguration
@Test(groups = "status")
public class StatusRepositoryIT extends AbstractTestNGSpringContextTests  {

    @Inject
    private StatusRepository statusRepository;
    
    @Inject
    private DominioFactory dominioFactory;
    
    @BeforeMethod
    void deleteAll(){
        statusRepository.deleteAll();
        assertThat(statusRepository.findAll()).isEmpty();
    }
    
    public void repositoryNotNull () {
        assertThat(statusRepository).isNotNull();
    }
    
    
    public void testSaveOne(){
        // Creates the test environment and save status
        Status status = dominioFactory.status();
        
        // Verifies if saved
        assertThat(statusRepository.findAll().iterator().next()).isEqualTo(status);
        
    }
    
    
     public void testDeleteOne(){
        // Creates the test environment and save status
        Status status = dominioFactory.status();
        
        // Deletes
        this.statusRepository.delete(status);
        
        //Test if deleted
        assertThat(statusRepository.findOne(status.getId())).isNull();
    }
     
     
     public void testFindByLabel(){
         // Creates the test environment and save status
        Status status1 = dominioFactory.status();
        // Creates the test environment and save status
        Status status2 = dominioFactory.status2();
         
         statusRepository.save(status1);
         statusRepository.save(status2);
         
         assertThat(statusRepository
                 .findByLabel(dominioFactory.getSTATUS_LABEL()))
                 .isEqualTo(status1);

         assertThat(statusRepository.findByLabel(dominioFactory
                 .getSTATUS_LABEL2()))
                 .isEqualTo(status2);
     }
    
}
