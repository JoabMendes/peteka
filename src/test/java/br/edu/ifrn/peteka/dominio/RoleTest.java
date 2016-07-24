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
public class RoleTest {

	private static final String TITLE1 = "title1";
	private static final String TITLE2 = "title2";

	public void equalTitles() {
		assertThat(Role.builder().title(TITLE1).build())
				.isEqualTo(Role.builder().title(TITLE1).build());
	}

	public void differentTitles() {
		assertThat(Role.builder().title(TITLE1).build())
				.isNotEqualTo(Role.builder().title(TITLE2).build());
	}

	public void compareToDifferentTitles() {
		Set<Role> roles = new TreeSet<>();

		Role r1 = Role.builder().title(TITLE2).build();
		Role r2 = Role.builder().title(TITLE1).build();
		roles.add(r1);
		roles.add(r2);

		assertThat(roles.iterator().next()).isEqualTo(r2);
	}

}
