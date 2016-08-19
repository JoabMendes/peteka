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
package br.edu.ifrn.peteka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Classe main.
 *
 * @author Duarte Fernandes
 */
@SpringBootApplication
public class PetekaApplication {

	private static SpringApplicationBuilder springApplicationBuilder
			= new SpringApplicationBuilder();

	public static void setSpringApplicationBuilder(SpringApplicationBuilder springApplicationBuilder) {
		PetekaApplication.springApplicationBuilder = springApplicationBuilder;
	}

	protected PetekaApplication() {

	}

	public static void main(String[] args) {
		springApplicationBuilder
				.sources(PetekaApplication.class)
				.run(args);
	}
}
