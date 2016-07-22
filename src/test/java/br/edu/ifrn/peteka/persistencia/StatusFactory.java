/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.Status;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author duartemac
 */
@Named
public class StatusFactory {

	// Status data
	public final static String STATUS_OPEN = "OPEN";
	public final static String STATUS_IN_PROGRESS = "IN PROGRESS";

	@Inject
	private StatusRepository statusRepository;

	public String getSTATUS_OPEN() {
		return STATUS_OPEN;
	}

	public String getSTATUS_IN_PROGRESS() {
		return STATUS_IN_PROGRESS;
	}

	private Status status(String label) {
		Status status = this.statusRepository.findByLabel(label);

		if (status == null) {
			status = Status.builder()
					.label(label)
					.build();

			this.statusRepository.save(status);
		}

		return status;
	}

	public Status open() {
		return status(STATUS_OPEN);
	}

	public Status inProgress() {
		return status(STATUS_IN_PROGRESS);
	}
}
