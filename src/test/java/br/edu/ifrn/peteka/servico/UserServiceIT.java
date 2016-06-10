/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.servico;

import br.edu.ifrn.peteka.PetekaApplication;
import br.edu.ifrn.peteka.dominio.Role;
import br.edu.ifrn.peteka.dominio.User;
import br.edu.ifrn.peteka.persistencia.DominioFactory;
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
@Test(groups = "user", dependsOnGroups = "role")
public class UserServiceIT extends AbstractTestNGSpringContextTests  {
    
    @Inject
    private UserService userService;
    @Inject
    private DominioFactory dominioFactory;
    
    @BeforeMethod
    void deleteAll()
    {
        userService.deleteAll();
        assertThat(userService.findAll()).isEmpty();
    }
    
    
    public void testServiceIsNotNull(){
        assertThat(userService).isNotNull();
    }
    
    public void testSaveOne(){
        // Creates the test environment and save user
        User user = dominioFactory.user();
        
        // Verifies if saved
        assertThat(this.userService.findAll().iterator().next()).isEqualTo(user);
        
    }
    
    
    public void testDeleteOne(){
        // Creates the test environment and save user
        User user = dominioFactory.user();
        
        // Deletes
        this.userService.delete(user);
        
        //Test if deleted
        assertThat(this.userService.findAll().iterator().hasNext()).isFalse();
    }
    
    public void testGetAllUsersOfRole() {
        // Creates the test environment and save role
        Role role = dominioFactory.role();
        // Creates the test environment and save user
        User user = dominioFactory.user(role);
        
        assertThat(userService.getAllUsersOfRole(role).contains(user));
    }
}