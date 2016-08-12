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

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author joab
 */
@Test
public class ProjectTest {

	private static final String TITLE1 = "title1";
	private static final String TITLE2 = "title2";
	private static final String DESCRIPTION1 = "description1";
	private static final String DESCRIPTION2 = "description2";
	private static final String FIRST = "A";
	private static final String SECOND = "B";

	public void equalTitles() {
		assertThat(Project.builder().title(TITLE1).build())
				.isEqualTo(Project.builder().title(TITLE1).build());
	}

	public void differentTitles() {
		assertThat(Project.builder().title(TITLE1).build())
				.isNotEqualTo(Project.builder().title(TITLE2).build());
	}

	public void secondProjectTitleIsNull() {
		assertThat(Project.builder().title(TITLE1).build())
				.isGreaterThan(Project.builder().title(null).build());
	}

	public void firstProjectTitleIsNull() {
		assertThat(Project.builder().title(null).build())
				.isLessThan(Project.builder().title(TITLE1).build());
	}

	public void bothTitlesAreNullButDescriptionsAreEqual() {
		assertThat(Project.builder().title(null).description(DESCRIPTION1).build())
				.isEqualTo(Project.builder().title(null).description(DESCRIPTION1).build());
	}

	public void equalTitlesDifferentDescriptions() {
		assertThat(Project.builder().title(TITLE1).description(DESCRIPTION1).build())
				.isNotEqualTo(Project.builder().title(TITLE1).description(DESCRIPTION2).build());
	}

	public void equalTitlesEqualDescriptions() {
		assertThat(Project.builder().title(TITLE1).description(DESCRIPTION1).build())
				.isEqualTo(Project.builder().title(TITLE1).description(DESCRIPTION1).build());
	}

	public void differentTitlesEqualDescriptions() {
		assertThat(Project.builder().title(TITLE1).description(DESCRIPTION1).build())
				.isNotEqualTo(Project.builder().title(TITLE2).description(DESCRIPTION1).build());
	}

	public void differentTitlesDifferentDescriptions() {
		assertThat(Project.builder().title(TITLE1).description(DESCRIPTION1).build())
				.isNotEqualTo(Project.builder().title(TITLE2).description(DESCRIPTION2).build());
	}

	public void compareToEqualTitlesDifferentDescriptions() {
		Set<Project> projects = new TreeSet<>();

		Project p1 = Project.builder().title(TITLE1).description(SECOND).build();
		Project p2 = Project.builder().title(TITLE1).description(FIRST).build();
		projects.add(p1);
		projects.add(p2);

		assertThat(projects.iterator().next()).isEqualTo(p2);
	}

	public void compareToDifferentTitlesDifferentDescriptions() {
		Set<Project> projects = new TreeSet<>();

		Project p1 = Project.builder().title(TITLE2).description(FIRST).build();
		Project p2 = Project.builder().title(TITLE1).description(SECOND).build();

		projects.add(p1);
		projects.add(p2);

		assertThat(projects.iterator().next()).isEqualTo(p2);
	}

	public void testProjectTasks() {
		Users u1 = Users.builder().nickname("Nome").build();
		Task t1 = Task.builder().assignee(u1).build();
		Set<Task> tasks = new HashSet<>();
		tasks.add(t1);
		Project p1 = Project.builder().title(TITLE1).tasks(tasks).build();
		assertThat(p1.getTasks().contains(t1))
				.isTrue();
	}

}
