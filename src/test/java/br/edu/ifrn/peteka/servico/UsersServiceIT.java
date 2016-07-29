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

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import br.edu.ifrn.peteka.PetekaApplication;
import br.edu.ifrn.peteka.dominio.Role;
import br.edu.ifrn.peteka.dominio.Users;
import br.edu.ifrn.peteka.persistencia.RoleFactory;
import br.edu.ifrn.peteka.persistencia.UsersFactory;

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
@Test(groups = "user", dependsOnGroups = "role")
public class UsersServiceIT extends AbstractTestNGSpringContextTests {

	@Inject
	private UsersService userService;
	@Inject
	private UsersFactory usersFactory;
	@Inject
	private RoleFactory roleFactory;

	@BeforeMethod
	void deleteAll() {
		userService.deleteAll();
		assertThat(userService.findAll()).isEmpty();
	}

	public void testServiceIsNotNull() {
		assertThat(userService).isNotNull();
	}

	public void testSaveOne() {
		// Creates the test environment and save user
		Users user = usersFactory.fred();

		// Verifies if saved
		assertThat(this.userService.findAll().iterator().next()).isEqualTo(user);

	}

	public void testSaveAll() {
		Set<Users> usersList = new HashSet<>();

		usersList.add(usersFactory.fred());
		usersList.add(usersFactory.mike());

		Set<Users> savedUsers = this.userService.saveAll(usersList);
		assertThat(usersList.equals(savedUsers)).isTrue();

	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testSaveOneWithBadNickname() throws IllegalArgumentException {
		String BAD_NICKNAME = "I'M_DUMB!!!"; //Not alphanumeric
		Users user = usersFactory.no_nick(BAD_NICKNAME);
		this.userService.save(user);
	}

	public void testDeleteOne() {
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

		assertThat(userService.getAllUsersOfRole(role)
			.contains(user)).isTrue();
	}
}
