package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.PetekaApplication;
import br.edu.ifrn.peteka.dominio.Status;
import javax.inject.Inject;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
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
