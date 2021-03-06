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

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrn.peteka.dominio.Project;
import br.edu.ifrn.peteka.dominio.Status;
import br.edu.ifrn.peteka.dominio.Task;
import br.edu.ifrn.peteka.persistencia.TaskRepository;

/**
 * Servico de Task.
 * @author Duarte Fernandes
 */
@Named
public class TaskService extends AbstractService<Task, Long> {

	private TaskRepository taskRepository;

	@Inject
	public TaskService(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}

	public List<Task> getAllTasksForProject(Project p) {
		return this.taskRepository.getAllTasksForProject(p);
	}

	public List<Task> getAllTasksForProjectOfStatus(Project p, Status s) {
		return this.taskRepository.getAllTasksForProjectOfStatus(p, s);
	}
}
