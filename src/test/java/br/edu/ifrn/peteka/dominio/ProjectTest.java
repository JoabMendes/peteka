/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.dominio;

import java.util.Set;
import java.util.TreeSet;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

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

}
