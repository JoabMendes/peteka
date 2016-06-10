/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.PetekaApplication;
import br.edu.ifrn.peteka.dominio.Role;
import br.edu.ifrn.peteka.dominio.User;
import javax.inject.Inject;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Example;
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
@Test(groups = "user")
public class UserRepositoryIT extends AbstractTestNGSpringContextTests  {
    
    @Inject
    private UserRepository userRepository;
    
    private final String USER_NICKNAME = "nickname";
    private final String USER_NICKNAME2 = "nickname2";
    private final String USER_NAME = "nome";
    
    
    @BeforeMethod
    void deleteAll(){
        userRepository.deleteAll();
        assertThat(userRepository.findAll()).isEmpty();
    }

    
    public void testRepositoryIsNotNull(){
        assertThat(userRepository).isNotNull();
    }
    
    public void testSaveOne(){
        // Creates the test environment
        User user = User.builder()
                .nickname(this.USER_NICKNAME)
                .name(this.USER_NAME).build();
        
        // Saves
        this.userRepository.save(user);
        
        // Verifies if saved
        assertThat(userRepository.findAll().iterator().next()).isEqualTo(user);
        
    }
    
    
    public void testDeleteOne(){
        // Creates the test environment
        // Creates the test environment
        User user = User.builder()
                .nickname(this.USER_NICKNAME)
                .name(this.USER_NAME).build();
        this.userRepository.save(user);
        
        // Deletes
        this.userRepository.delete(user);
        
        //Test if deleted
        assertThat(userRepository.findOne(user.getId())).isNull();
    }
    
    // Using query by example, test do not apply
    /*
    public void testFindByNickname(){
        User user1 = User.builder()
                .nickname(this.USER_NICKNAME)
                .name(this.USER_NAME).build();
        this.userRepository.save(user1);
        User user2 = User.builder()
                .nickname(this.USER_NICKNAME2)
                .name(this.USER_NAME).build();
        this.userRepository.save(user2);
        
        assertThat(userRepository.findByNickname(this.USER_NICKNAME)).isEqualTo(user1);
        assertThat(userRepository.findByNickname(this.USER_NICKNAME2)).isEqualTo(user2);
        
    }
    */
    

    public void findAllByExample () {
        // cria o ambiente de teste
        User user = User.builder()
                .nickname(this.USER_NICKNAME)
                .name(this.USER_NAME).build();
        this.userRepository.save(user);
        
        User userExample = User.builder()
                .nickname(this.USER_NICKNAME)
                .name(this.USER_NAME).build();
        
        assertThat(this.userRepository.findAll(Example.of(userExample)).iterator().next())
            .isEqualTo(user);
    }

    public void testGetAllUsersOfRole() {
        // Creates the test environment
        Role role = Role.builder()
                .title("Role")
                .build();
        User user = User.builder()
                .nickname(this.USER_NICKNAME)
                .name(this.USER_NAME)
                .role(role)
                .build();
        
        assertThat(userRepository.getAllUsersOfRole(role).contains(user));
    }
}
