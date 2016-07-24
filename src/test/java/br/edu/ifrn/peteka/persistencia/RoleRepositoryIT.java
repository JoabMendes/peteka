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
package br.edu.ifrn.peteka.persistencia;


import javax.inject.Inject;

import br.edu.ifrn.peteka.PetekaApplication;
import br.edu.ifrn.peteka.dominio.Role;

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
public class RoleRepositoryIT extends AbstractTestNGSpringContextTests {

	@Inject
	private RoleRepository roleRepository;
	@Inject
	private UsersRepository userRepository;
	@Inject
	private RoleFactory roleFactory;

	@BeforeMethod
	void deleteAll() {
		userRepository.deleteAll();
		roleRepository.deleteAll();
		assertThat(roleRepository.findAll()).isEmpty();
	}

	public void repositoryNotNull() {
		assertThat(roleRepository).isNotNull();
	}

	public void testDeleteOne() {
		// Creates the test environment and save role
		Role role = roleFactory.admin();

		// Deletes
		this.roleRepository.delete(role);

		//Test if deleted
		assertThat(roleRepository.findOne(role.getId())).isNull();
	}

	public void testSaveOne() {
		// Creates the test environment and save role
		Role role = roleFactory.admin();

		// Verifies if saved
		assertThat(roleRepository.findAll().iterator().next()).isEqualTo(role);

	}

	public void testFindByTitle() {
		// Creates the test environment and save role
		Role admin = roleFactory.admin();
		// Creates the test environment and save role
		Role manager = roleFactory.manager();

		assertThat(roleRepository.findByTitle(roleFactory.getROLE_ADMIN()))
				.isEqualTo(admin);
		assertThat(roleRepository.findByTitle(roleFactory.getROLE_MANAGER()))
				.isEqualTo(manager);

	}

}
