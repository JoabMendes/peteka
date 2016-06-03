/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.PetekaApplication;
import br.edu.ifrn.peteka.dominio.Role;
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
public class RoleRepositoryTest extends AbstractTestNGSpringContextTests{
    
    @Inject
    private RoleRepository roleRepository;
    
    private static final String ROLE_TITLE = "title";
    
    public void testRepositoryIsNotNull(){
        assertThat(roleRepository).isNotNull();
    }
    
    public void testSaveOne(){
        // Creates the test environment
        Role role = Role.builder().title(this.ROLE_TITLE).build();
        
        // Saves
        this.roleRepository.save(role);
        
        // Verifies if saved
        assertThat(this.roleRepository.iterator().next()).isEqualTo(role);
        
    }
    
    
    public void testDeleteOne(){
        // Creates the test environment
        Role role = Role.builder().title(this.ROLE_TITLE).build();
        
        // Saves
        this.roleRepository.save(role);
        
        // Deletes
        this.roleRepository.delete(role);
        
        //Test if deleted
        assertThat(this.roleRepository.iterator().hasNext()).isFalse();
    }
    
}
