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
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrn.peteka.dominio.Role;
import br.edu.ifrn.peteka.dominio.Users;
import br.edu.ifrn.peteka.persistencia.UsersRepository;

import org.springframework.transaction.annotation.Transactional;

/**
 * Servico de Users.
 * @author Duarte Fernandes
 */
@Named
public class UsersService extends AbstractService<Users, Long> {

	private UsersRepository usersRepository;

	@Inject
	public UsersService(UsersRepository userRepository) {
		super();
		this.usersRepository = userRepository;
	}

	public List<Users> getAllUsersOfRole(Role r) {
		return this.usersRepository.getAllUsersOfRole(r);
	}

	@Override
	@Transactional
	public Users save(Users user) {
		user.verifyNickName(); //Nickname must be alphanumeric
		super.save(user);
		return user;
	}

	@Transactional
	public Set<Users> saveAll(Set<Users> users) {
		Set<Users> savedUsers = new HashSet<>();

		for (Users user : users) {
			user.verifyNickName();
			savedUsers.add(this.usersRepository.save(user));
		}

		return savedUsers;
	}

}
