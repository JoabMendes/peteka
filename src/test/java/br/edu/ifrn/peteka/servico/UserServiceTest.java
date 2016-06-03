/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.servico;

import br.edu.ifrn.peteka.PetekaApplication;
import br.edu.ifrn.peteka.dominio.User;
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
public class UserServiceTest extends AbstractTestNGSpringContextTests  {
    
    @Inject
    private UserService userService;
    private final String USER_NICKNAME = "nickname";
    private final String USER_NAME = "nome";
    
    public void testServiceIsNotNull(){
        assertThat(userService).isNotNull();
    }
    
    public void testSaveOne(){
        // Creates the test environment
        User user = User.builder()
                .nickname(this.USER_NICKNAME)
                .name(this.USER_NAME).build();
        
        // Saves
        this.userService.save(user);
        
        // Verifies if saved
        assertThat(this.userService.iterator().next()).isEqualTo(user);
        
    }
    
    
    public void testDeleteOne(){
        // Creates the test environment
        // Creates the test environment
        User user = User.builder()
                .nickname(this.USER_NICKNAME)
                .name(this.USER_NAME).build();
        this.userService.save(user);
        
        // Deletes
        this.userService.delete(user);
        
        //Test if deleted
        assertThat(this.userService.iterator().hasNext()).isFalse();
    }
    
    
}
