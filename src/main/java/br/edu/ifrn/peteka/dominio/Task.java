/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.dominio;

import java.io.Serializable;
import java.util.Set;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = {"project", "status", "assignees", "id", "description"})
@Builder
@Entity
@SequenceGenerator(sequenceName = "seq_task", name = "ID_SEQUENCE", allocationSize = 1)
public class Task implements Serializable, Comparable<Task> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
    private Long id;

    @NonNull
    @ManyToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_task_project"))
    private Project project;

    @NonNull
    @ManyToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_task_status"))
    private Status status;

    @Singular
    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
    private Set<User> assignees;

    @Column(nullable = false)
    private String title;

    private String description;
    
    
    @Override
    public int compareTo(Task o) {
        return title.compareTo(o.title);
    }
    
}
