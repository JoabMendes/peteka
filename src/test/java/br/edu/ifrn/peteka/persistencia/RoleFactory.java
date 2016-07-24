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

/**
 *
 * @author Duarte Fernandes
 */
@Named
public class RoleFactory {

	// Role data
	public final static String ROLE_ADMIN = "ADMIN";
	public final static String ROLE_MANAGER = "MANAGER";

	@Inject
	private RoleRepository roleRepository;

	public String getROLE_ADMIN() {
		return ROLE_ADMIN;
	}

	public String getROLE_MANAGER() {
		return ROLE_MANAGER;
	}

	private Role role(String title) {
		Role role = this.roleRepository.findByTitle(title);

		if (role == null) {
			role = Role.builder()
					.title(title)
					.build();

			this.roleRepository.save(role);
		}

		return role;
	}

	public Role admin() {
		return role(ROLE_ADMIN);
	}

	public Role manager() {
		return role(ROLE_MANAGER);
	}
}
