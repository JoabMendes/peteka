/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.dominio;

import java.util.Set;
import java.util.TreeSet;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;


/**
 *
 * @author joab
 */
@Test
public class RoleTest {
    
    private final String TITLE1 = "title1";
    private final String TITLE2 = "title2";
    
    public void equalTitles(){
        assertThat(Role.builder().title(TITLE1).build())
            .isEqualTo(Role.builder().title(TITLE1).build());
    }
    
    public void differentTitles(){
        assertThat(Role.builder().title(TITLE1).build())
            .isNotEqualTo(Role.builder().title(TITLE2).build());
    }
    
    public void compareToDifferentTitles(){
        Set<Role> roles = new TreeSet<>();
        
        Role r1 = Role.builder().title(TITLE2).build();
        Role r2 = Role.builder().title(TITLE1).build();
        roles.add(r1);
        roles.add(r2);
        
        assertThat(roles.iterator().next()).isEqualTo(r2);
    }
    
}
