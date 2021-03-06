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
package br.edu.ifrn.peteka.visao.crud;


import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.edu.ifrn.peteka.dominio.Project;
import br.edu.ifrn.peteka.dominio.Status;
import br.edu.ifrn.peteka.dominio.Task;
import br.edu.ifrn.peteka.dominio.Users;

/**
 * CrudMBean de Task.
 * @author Duarte Fernandes
 */
@ViewScoped
@Named
public class TaskCrudMBean extends CrudMBean<Task, Long> {

	@Override
	protected Task createBean() {
		return Task.builder()
			.status(Status.builder().build())
			.project(Project.builder().build())
			.assignee(Users.builder().build())
			.build();
	}

}
