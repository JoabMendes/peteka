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
import br.edu.ifrn.peteka.dominio.Users;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Example;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

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

		assertThat(userRepository.getAllUsersOfRole(role)
			.contains(user)).isTrue();
	}
}
