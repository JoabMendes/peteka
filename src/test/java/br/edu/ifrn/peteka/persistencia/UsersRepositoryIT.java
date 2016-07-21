/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.PetekaApplication;
import br.edu.ifrn.peteka.dominio.Role;
import br.edu.ifrn.peteka.dominio.Users;
import javax.inject.Inject;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Example;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author joab
 */
@SpringApplicationConfiguration(classes = PetekaApplication.class)
@WebAppConfiguration
@Test(groups = "user", dependsOnGroups = "role")
public class UsersRepositoryIT extends AbstractTestNGSpringContextTests {

    @Inject
    private UsersRepository userRepository;

    @Inject
    private UsersFactory userFactory;

    @Inject
    private RoleFactory roleFactory;

    @BeforeMethod
    void deleteAll() {
        userRepository.deleteAll();
        assertThat(userRepository.findAll()).isEmpty();
    }

    public void testRepositoryIsNotNull() {
        assertThat(userRepository).isNotNull();
    }

    public void testSaveOne() {
        // Creates the test environment and save user
        Users user = userFactory.fred();

        // Verifies if saved
        assertThat(userRepository.findAll().iterator().next()).isEqualTo(user);

    }

    public void testDeleteOne() {
        // Creates the test environment and save user
        Users user = userFactory.fred();

        // Deletes
        this.userRepository.delete(user);

        //Test if deleted
        assertThat(userRepository.findOne(user.getId())).isNull();
    }

    // Using query by example, test do not apply
    /*
    public void testFindByNickname(){
        // Creates the test environment and save user
        Users user1 = modelFactory.user();
        // Creates the test environment and save user
        Users user2 = modelFactory.user();
        
        assertThat(userRepository.findByNickname(this.USER_NICKNAME)).isEqualTo(user1);
        assertThat(userRepository.findByNickname(this.USER_NICKNAME2)).isEqualTo(user2);
        
    }
     */
    public void findAllByExample() {
        // Creates the test environment and save user
        Users user = userFactory.mike();

        // Creates the test environment and save user
        Users userExample = userFactory.mike();

        assertThat(this.userRepository.findAll(Example.of(userExample)).iterator().next())
                .isEqualTo(user);
    }

    public void testGetAllUsersOfRole() {
        // Creates the test environment and save role
        Role role = roleFactory.admin();
        // Creates the test environment and save user
        Users user = userFactory.user(role);

        assertThat(userRepository.getAllUsersOfRole(role).contains(user));
    }
}
