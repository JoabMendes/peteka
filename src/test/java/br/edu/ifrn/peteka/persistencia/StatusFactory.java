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

import br.edu.ifrn.peteka.dominio.Status;

/**
 *
 * @author Duarte Fernandes
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
