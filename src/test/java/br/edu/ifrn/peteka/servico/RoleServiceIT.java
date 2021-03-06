/*
 * Copyright 2016 Peteka.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.edu.ifrn.peteka.servico;


import javax.inject.Inject;

import br.edu.ifrn.peteka.PetekaApplication;
import br.edu.ifrn.peteka.dominio.Role;
import br.edu.ifrn.peteka.persistencia.RoleFactory;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

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
