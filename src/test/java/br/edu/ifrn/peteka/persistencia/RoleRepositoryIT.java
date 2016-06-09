/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.PetekaApplication;
import br.edu.ifrn.peteka.dominio.Role;
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
public class RoleRepositoryIT extends AbstractTestNGSpringContextTests {
    
    @Inject
    private RoleRepository roleRepository;
    
    private final String ROLE_TITLE = "title";
    
    @BeforeMethod
    void deleteAll(){
        roleRepository.deleteAll();
        assertThat(roleRepository.findAll()).isEmpty();
    }
    
    public void repositoryNotNull () {
        assertThat(roleRepository).isNotNull();
    }
    
    public void testDeleteOne(){
        // Creates the test environment
        Role role = Role.builder().title(this.ROLE_TITLE).build();
        
        // Saves
        this.roleRepository.save(role);
        
        // Deletes
        this.roleRepository.delete(role);
        
        //Test if deleted
         assertThat(roleRepository.findOne(role.getId())).isNull();
    }
    
    public void testSaveOne(){
        // Creates the test environment
        Role role = Role.builder().title(this.ROLE_TITLE).build();
        
        // Saves
        this.roleRepository.save(role);
        
        // Verifies if saved
        assertThat(roleRepository.findAll().iterator().next()).isEqualTo(role);
        
    }
    
    
}
