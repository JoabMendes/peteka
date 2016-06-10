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
    
    @Inject
    private DominioFactory dominioFactory;
    
    @BeforeMethod
    void deleteAll(){
        roleRepository.deleteAll();
        assertThat(roleRepository.findAll()).isEmpty();
    }
    
    public void repositoryNotNull () {
        assertThat(roleRepository).isNotNull();
    }
    
    public void testDeleteOne(){
        // Creates the test environment and save role
        Role role = dominioFactory.role();
        
        // Deletes
        this.roleRepository.delete(role);
        
        //Test if deleted
         assertThat(roleRepository.findOne(role.getId())).isNull();
    }
    
    public void testSaveOne(){
        // Creates the test environment and save role
        Role role = dominioFactory.role();
        
        // Verifies if saved
        assertThat(roleRepository.findAll().iterator().next()).isEqualTo(role);
        
    }
    
    
    public void testFindByTitle(){
        // Creates the test environment and save role
        Role role1 = dominioFactory.role();
        // Creates the test environment and save role
        Role role2 = dominioFactory.role2();
        
        assertThat(roleRepository.findByTitle(dominioFactory.getROLE_TITLE()))
                .isEqualTo(role1);
        assertThat(roleRepository.findByTitle(dominioFactory.getROLE_TITLE2()))
                .isEqualTo(role2);
        
    }
    
    
}
