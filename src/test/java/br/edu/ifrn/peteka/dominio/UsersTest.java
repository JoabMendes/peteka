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
package br.edu.ifrn.peteka.dominio;

import java.util.Set;
import java.util.TreeSet;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author joab
 */
@Test
public class UsersTest {

	private static final String NICKNAME1 = "nickname1";
	private static final String NICKNAME2 = "nickname2";
	private static final String NAME1 = "nome1";
	private static final String NAME2 = "nome2";

	public void equalNicknames() {
		assertThat(Users.builder().nickname(NICKNAME1).build())
				.isEqualTo(Users.builder().nickname(NICKNAME1).build());
	}

	public void differentNicknames() {
		assertThat(Users.builder().nickname(NICKNAME1).build())
				.isNotEqualTo(Users.builder().nickname(NICKNAME2).build());
	}

	//Just to test if the exclude is working
	public void differentNicknamesSameNames() {
		assertThat(Users.builder().nickname(NICKNAME1).name(NAME1).build())
				.isNotEqualTo(Users.builder().nickname(NICKNAME2).name(NAME1).build());
	}

	//Just to test if the exclude is working
	public void sameNicknamesdifferentNames() {
		assertThat(Users.builder().nickname(NICKNAME1).name(NAME1).build())
				.isEqualTo(Users.builder().nickname(NICKNAME1).name(NAME2).build());
	}

	public void compareToDifferentNicknames() {
		Set<Users> users = new TreeSet<>();

		Users u1 = Users.builder().nickname(NICKNAME2).build();
		Users u2 = Users.builder().nickname(NICKNAME1).build();
		users.add(u1);
		users.add(u2);

		assertThat(users.iterator().next()).isEqualTo(u2);
	}

}
