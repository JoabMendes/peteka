/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.dominio;

import java.io.Serializable;
import java.util.Set;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"title", "description"})
@Builder
@Entity
@SequenceGenerator(sequenceName = "seq_project", name = "ID_SEQUENCE", allocationSize = 1)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Project implements Serializable, Comparable<Project> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
    private Long id;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private Set<Task> tasks;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;
    
    @Override
    public int compareTo(Project o) {
        int result = title.compareTo(o.title);
        if(result == 0){
            result = description.compareTo(o.description);
        }
        return result;
    }

}
