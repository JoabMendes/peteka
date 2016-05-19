/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.dominio;
import java.util.Set;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Singular;

/**
 *
 * @author joab
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = {"project", "status", "assignees", "id", "description"})
@Builder
public class Task {
    private Project project;
    private Status status;
    @Singular
    private Set<User> assignees;
    private Long id;
    private String title;
    private String description;
}
