/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.servico;

import br.edu.ifrn.peteka.PetekaApplication;
import br.edu.ifrn.peteka.dominio.Role;
import br.edu.ifrn.peteka.dominio.Users;
import br.edu.ifrn.peteka.persistencia.RoleFactory;
import br.edu.ifrn.peteka.persistencia.UsersFactory;
import javax.inject.Inject;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.boot.test.SpringApplicationConfiguration;
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
@Test(groups = "user", dependsOnGroups = "role")
public class UsersServiceIT extends AbstractTestNGSpringContextTests  {
    
    @Inject
    private UsersService userService;
    @Inject
    private UsersFactory usersFactory;
    @Inject
    private RoleFactory roleFactory;
    
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
        Users user = usersFactory.fred();
        
        // Verifies if saved
        assertThat(this.userService.findAll().iterator().next()).isEqualTo(user);
        
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSaveOneWithBadNickname() throws IllegalArgumentException{
        String BAD_NICKNAME = "I'M_DUMB!!!"; //Not alphanumeric
        Users user = usersFactory.no_nick(BAD_NICKNAME);
        this.userService.save(user);
    }
    
    
    public void testDeleteOne(){
        // Creates the test environment and save user
        Users user = usersFactory.mike();
        
        // Deletes
        this.userService.delete(user);
        
        //Test if deleted
        assertThat(this.userService.findAll().iterator().hasNext()).isFalse();
    }
    
    public void testGetAllUsersOfRole() {
        // Creates the test environment and save role
        Role role = roleFactory.admin();
        // Creates the test environment and save user
        Users user = usersFactory.user(role);
        
        assertThat(userService.getAllUsersOfRole(role).contains(user));
    }
}