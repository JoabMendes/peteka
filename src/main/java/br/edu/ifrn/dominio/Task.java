/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.dominio;
import java.util.ArrayList;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author joab
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class Task {
    private Project project;
    private Status status;
    private ArrayList<User> assignees;
    private Long id;
    private String title;
    private String description;
}
