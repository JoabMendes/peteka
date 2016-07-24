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
import br.edu.ifrn.peteka.dominio.Project;
import br.edu.ifrn.peteka.dominio.Users;
import br.edu.ifrn.peteka.persistencia.ProjectFactory;
import br.edu.ifrn.peteka.persistencia.TaskFactory;
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
@Test(groups = "project")
public class ProjectServiceIT extends AbstractTestNGSpringContextTests {

	@Inject
	private ProjectService projectService;
	@Inject
	private TaskService taskService;
	@Inject
	private ProjectFactory projectFactory;
	@Inject
	private UsersFactory usersFactory;
	@Inject
	private TaskFactory taskFactory;

	@BeforeMethod
	void deleteAll() {
		taskService.deleteAll();
		projectService.deleteAll();
		assertThat(projectService.findAll()).isEmpty();
	}

	public void testServiceIsNotNull() {
		assertThat(projectService).isNotNull();
	}

	public void testSaveOne() {
		// Creates the test environment and save it
		Project project = projectFactory.project();

		// Verifies if saved
		assertThat(this.projectService.findAll().iterator().next())
				.isEqualTo(project);
	}

	public void testDeleteOne() {
		// Creates the test environment and save it
		Project project = projectFactory.project();

		// Deletes
		this.projectService.delete(project);

		//Test if deleted
		assertThat(this.projectService.findAll().iterator().hasNext()).isFalse();
	}

	public void testGetAllProjectsOfUser() {
		// Creates the test environment
		Users user = usersFactory.fred();

		Project project = projectFactory.project();

		taskFactory.task(project, user);

		assertThat(projectService.getAllProjectsOfUser(user)
				.contains(project));
	}

}
