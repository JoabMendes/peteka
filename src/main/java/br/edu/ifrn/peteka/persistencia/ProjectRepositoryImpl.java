/*
 * Copyright 2016-2016 the original author or authors.
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

import br.edu.ifrn.peteka.dominio.Project;
import br.edu.ifrn.peteka.dominio.QProject;
import br.edu.ifrn.peteka.dominio.Users;
import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author duartemac
 */
public class ProjectRepositoryImpl implements ProjectRepositoryCustom {

	private final EntityManager entityManager;

	/**
	 *
	 * @param entityManager
	 */
	@Inject
	public ProjectRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Project> getAllProjectsOfUser(Users u) {
		QProject qProject = QProject.project;
		JPQLQueryFactory factory = new JPAQueryFactory(entityManager);

		List<Project> projects = (List<Project>) factory
				.from(qProject)
				.where(qProject.tasks.any().assignees.contains(u))
				.fetch();
		return projects;
	}

}
