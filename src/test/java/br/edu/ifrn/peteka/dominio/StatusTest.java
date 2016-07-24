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

import java.util.Set;
import java.util.TreeSet;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author joab
 */
@Test
public class StatusTest {

	private static final String LABEL1 = "label1";
	private static final String LABEL2 = "label2";

	public void equalLabels() {
		assertThat(Status.builder().label(LABEL1).build())
				.isEqualTo(Status.builder().label(LABEL1).build());
	}

	public void differentLabels() {
		assertThat(Status.builder().label(LABEL1).build())
				.isNotEqualTo(Status.builder().label(LABEL2).build());
	}

	public void compareToDifferentLabels() {
		Set<Status> statuses = new TreeSet<>();

		Status s1 = Status.builder().label(LABEL2).build();
		Status s2 = Status.builder().label(LABEL1).build();
		statuses.add(s1);
		statuses.add(s2);

		assertThat(statuses.iterator().next()).isEqualTo(s2);
	}

}
