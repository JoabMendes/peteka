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

/**
 *
 * @author Duarte Fernandes
 */
@Named
public class ProjectFactory {

	// Project data
	public final static String PROJECT_TITLE = "title";
	public final static String PROJECT_DESCRIPTION = "description";

	@Inject
	private ProjectRepository projectRepository;

	private Project project(String title, String description) {
		Project project = projectRepository
				.findByTitleAndDescription(title, description);

		if (project == null) {
			project = Project.builder()
					.title(title)
					.description(description)
					.build();

			this.projectRepository.save(project);
		}

		return project;
	}

	public Project project() {
		return this.project(PROJECT_TITLE, PROJECT_DESCRIPTION);
	}
}
