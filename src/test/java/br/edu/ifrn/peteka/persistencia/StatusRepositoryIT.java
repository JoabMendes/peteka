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
import br.edu.ifrn.peteka.dominio.Status;

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
@Test(groups = "status")
public class StatusRepositoryIT extends AbstractTestNGSpringContextTests {

	@Inject
	private StatusRepository statusRepository;
	@Inject
	private TaskRepository taskRepository;
	@Inject
	private StatusFactory statusFactory;

	@BeforeMethod
	void deleteAll() {
		taskRepository.deleteAll();
		statusRepository.deleteAll();
		assertThat(statusRepository.findAll()).isEmpty();
	}

	public void repositoryNotNull() {
		assertThat(statusRepository).isNotNull();
	}

	public void testSaveOne() {
		// Creates the test environment and save status
		Status status = statusFactory.inProgress();

		// Verifies if saved
		assertThat(statusRepository.findAll().iterator().next()).isEqualTo(status);

	}

	public void testDeleteOne() {
		// Creates the test environment and save status
		Status status = statusFactory.inProgress();

		// Deletes
		this.statusRepository.delete(status);

		//Test if deleted
		assertThat(statusRepository.findOne(status.getId())).isNull();
	}

	public void testFindByLabel() {
		// Creates the test environment and save status
		Status statusInProgress = statusFactory.inProgress();
		// Creates the test environment and save status
		Status statusOpen = statusFactory.open();

		statusRepository.save(statusInProgress);
		statusRepository.save(statusOpen);

		assertThat(statusRepository
				.findByLabel(statusFactory.getSTATUS_IN_PROGRESS()))
				.isEqualTo(statusInProgress);

		assertThat(statusRepository.findByLabel(statusFactory
				.getSTATUS_OPEN()))
				.isEqualTo(statusOpen);
	}

}
