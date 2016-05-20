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
@EqualsAndHashCode(exclude={"id", "name", "role"})
@Builder
public class User implements Comparable<User>{
    private Long id;
    private String nickname;
    private String name;
    private Role role;
    
    @Override
    public int compareTo(User o) {
        return nickname.compareTo(o.nickname);
    }
    
    
}
