/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.dominio;
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
public class Project {
    private Long id;
    private String title;
    private String description;

}
