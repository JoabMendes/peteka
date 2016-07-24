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
import br.edu.ifrn.peteka.dominio.Project;
import br.edu.ifrn.peteka.dominio.Users;

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
@Test(groups = "project")
public class ProjectRepositoryIT extends AbstractTestNGSpringContextTests {

	@Inject
	private ProjectRepository projectRepository;

	@Inject
	private ProjectFactory projectFactory;

	@Inject
	private UsersFactory userFactory;

	@Inject
	private TaskFactory taskFactory;

	@BeforeMethod
	void deleteAll() {
		projectRepository.deleteAll();
		assertThat(projectRepository.findAll()).isEmpty();
	}

	public void repositoryNotNull() {
		assertThat(projectRepository).isNotNull();
	}

	public void deleteOne() {
		// Creates the test environment
		Project project = projectFactory.project();

		//Verify function
		this.projectRepository.delete(project);

		// verifica o efeito da execucao da operacao a ser testada
		assertThat(projectRepository.findOne(project.getId())).isNull();
	}

	public void salvarUm() {
		// Creates test environment and save it
		Project project = projectFactory.project();

		// Verifies if saved
		assertThat(projectRepository.findAll().iterator().next()).isEqualTo(project);
	}

	public void testGetAllProjectsOfUser() {
		// Creates the test environment
		Users user = userFactory.fred();

		Project project = projectFactory.project();

		taskFactory.task(project, user);

		assertThat(projectRepository.getAllProjectsOfUser(user)
				.contains(project));
	}
}
