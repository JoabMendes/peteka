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

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;



/**
 * Task entity.
 *
 * @author Duarte Fernandes
 */
@Getter
@Setter
@ToString(exclude = {"assignees"})
@EqualsAndHashCode(of = {"title"})
@Builder
@Entity
@SequenceGenerator(sequenceName = "seq_task", name = "ID_SEQUENCE", allocationSize = 1)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Task implements Serializable, Comparable<Task> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
	private Long id;

	@ManyToOne
	@JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_task_project"))
	private Project project;

	@ManyToOne
	@JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_task_status"))
	private Status status;

	@Singular
	@OneToMany(fetch = FetchType.LAZY)
	private Set<Users> assignees;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String description;

	@Override
	public int compareTo(Task o) {
		return title.compareTo(o.title);
	}

}
