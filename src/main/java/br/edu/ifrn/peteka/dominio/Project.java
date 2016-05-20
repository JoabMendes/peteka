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
import lombok.NonNull;

/**
 *
 * @author joab
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = "id")
@Builder
public class Project implements Comparable<Project>{
    private Long id;
    @NonNull
    private String title;
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
