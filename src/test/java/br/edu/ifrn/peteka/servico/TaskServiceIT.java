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
import br.edu.ifrn.peteka.dominio.Status;
import br.edu.ifrn.peteka.dominio.Task;
import br.edu.ifrn.peteka.persistencia.ProjectFactory;
import br.edu.ifrn.peteka.persistencia.StatusFactory;
import br.edu.ifrn.peteka.persistencia.TaskFactory;

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
@Test(groups = "task", dependsOnGroups = {"project", "status"})
public class TaskServiceIT extends AbstractTestNGSpringContextTests {

	@Inject
	private TaskService taskService;

	@Inject
	private TaskFactory taskFactory;

	@Inject
	private ProjectFactory projectFactory;

	@Inject
	private StatusFactory statusFactory;

	@BeforeMethod
	void deleteAll() {
		taskService.deleteAll();
		assertThat(taskService.findAll()).isEmpty();
	}

	public void testServiceIsNotNull() {
		assertThat(taskService).isNotNull();
	}

	public void testSaveOne() {
		// Creates the test environment and save task
		Task task = taskFactory.task();

		// Verifies if saved
		assertThat(this.taskService.findAll().iterator().next()).isEqualTo(task);

	}

	public void testDeleteOne() {
		// Creates the test environment and save task
		Task task = taskFactory.task();

		// Deletes
		this.taskService.delete(task);

		//Test if deleted
		assertThat(this.taskService.findAll().iterator().hasNext()).isFalse();
	}

	public void testGetAllTasksForProject() {
		Project project = projectFactory.project();
		// Creates the test environment and save task
		Task task = taskFactory.task(project);

		assertThat(taskService.getAllTasksForProject(project)
				.contains(task));
	}

	public void testGetAllTasksForProjectOfStatus() {
		// Creates the test environment
		Project project = projectFactory.project();
		Status status = statusFactory.open();
		Task task = taskFactory.task(project, status);

		assertThat(taskService.getAllTasksForProjectOfStatus(project, status)
				.contains(task));
	}
}
