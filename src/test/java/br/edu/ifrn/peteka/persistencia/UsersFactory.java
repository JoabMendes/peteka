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
import javax.inject.Named;

import br.edu.ifrn.peteka.dominio.Role;
import br.edu.ifrn.peteka.dominio.Users;

/**
 *
 * @author Duarte Fernandes
 */
@Named
public class UsersFactory {

	// Users data
	public final static String USER_FRED = "FRED";
	public final static String USER_MIKE = "MIKE";
	public final static String USER_FRED_NAME = "FREDERICK";
	public final static String USER_MIKE_NAME = "MICHAEL";

	@Inject
	private UsersRepository userRepository;

	@Inject
	private RoleFactory roleFactory;

	private Users user(String nickname, String name, Role r) {
		Users user = this.userRepository.findByNickname(nickname);

		if (user == null) {
			user = Users.builder()
					.nickname(nickname)
					.name(name)
					.role(r)
					.build();

			this.userRepository.save(user);
		}

		return user;
	}

	public Users user(Role r) {
		return user(USER_MIKE, USER_MIKE_NAME, r);
	}

	public Users fred() {
		Role admin = roleFactory.admin();
		return user(USER_MIKE, USER_MIKE_NAME, admin);
	}

	public Users mike() {
		Role manager = roleFactory.manager();
		return user(USER_MIKE, USER_MIKE_NAME, manager);
	}

	public Users no_nick(String nickname) {
		Role manager = roleFactory.manager();
		return user(nickname, USER_MIKE_NAME, manager);
	}

}
