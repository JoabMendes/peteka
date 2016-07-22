/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.servico;

import br.edu.ifrn.peteka.PetekaApplication;
import br.edu.ifrn.peteka.dominio.Role;
import br.edu.ifrn.peteka.persistencia.RoleFactory;
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
@Test(groups = "role")
public class RoleServiceIT extends AbstractTestNGSpringContextTests {

	@Inject
	private RoleService roleService;
	@Inject
	private UsersService usersService;
	@Inject
	private RoleFactory roleFactory;

	@BeforeMethod
	void deleteAll() {
		usersService.deleteAll();
		roleService.deleteAll();
		assertThat(roleService.findAll()).isEmpty();
	}

	public void testServiceIsNotNull() {
		assertThat(roleService).isNotNull();
	}

	public void testSaveOne() {
		// Creates the test environment and save role
		Role role = roleFactory.admin();

		// Verifies if saved
		assertThat(this.roleService.findAll().iterator().next()).isEqualTo(role);

	}

	public void testDeleteOne() {
		// Creates the test environment and save role
		Role role = roleFactory.admin();

		// Deletes
		this.roleService.delete(role);

		//Test if deleted
		assertThat(this.roleService.findAll().iterator().hasNext()).isFalse();
	}

}
