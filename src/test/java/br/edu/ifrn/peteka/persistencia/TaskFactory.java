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

import br.edu.ifrn.peteka.dominio.Project;
import br.edu.ifrn.peteka.dominio.Status;
import br.edu.ifrn.peteka.dominio.Task;
import br.edu.ifrn.peteka.dominio.Users;

/**
 *
 * @author Duarte Fernandes
 */
@Named
public class TaskFactory {

	// Status data
	public final static String TASK_TITLE = "title";
	public final static String TASK_DESCRIPTION = "D1";

	@Inject
	private TaskRepository taskRepository;

	@Inject
	private StatusFactory statusFactory;

	@Inject
	private ProjectFactory projectFactory;

	@Inject
	private UsersFactory usersFactory;

	private Task task(String title, String description, Status st, Project p, Users u) {

		Task task = this.taskRepository.findByTitleAndDescription(title, description);
		if (task == null) {
			task = Task.builder()
					.title(title)
					.description(description)
					.status(st)
					.project(p)
					.assignee(u)
					.build();

			this.taskRepository.save(task);
		}

		return task;
	}

	public Task task() {
		Status st = this.statusFactory.open();
		Project p = this.projectFactory.project();
		Users u = this.usersFactory.mike();
		return this.task(TASK_TITLE, TASK_DESCRIPTION, st, p, u);
	}

	public Task task(Status st) {
		Project p = this.projectFactory.project();
		Users u = this.usersFactory.mike();
		return this.task(TASK_TITLE, TASK_DESCRIPTION, st, p, u);
	}

	public Task task(Project p) {
		Status st = this.statusFactory.open();
		Users u = this.usersFactory.mike();
		return this.task(TASK_TITLE, TASK_DESCRIPTION, st, p, u);
	}

	public Task task(Project p, Status st) {
		Users u = this.usersFactory.mike();
		return this.task(TASK_TITLE, TASK_DESCRIPTION, st, p, u);
	}

	public Task task(Project p, Users u) {
		Status st = this.statusFactory.open();
		return this.task(TASK_TITLE, TASK_DESCRIPTION, st, p, u);
	}
}
