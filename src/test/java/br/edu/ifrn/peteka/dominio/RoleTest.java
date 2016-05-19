/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.dominio;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author joab
 */
@Test
public class RoleTest {
    
    private final String TILE1 = "tile1";
    private final String TILE2 = "title2";
    
    public void equalTitles(){
        assertThat(Role.builder().title(TILE1).build())
            .isEqualTo(Role.builder().title(TILE1).build());
    }
    
    public void differentTitles(){
        assertThat(Role.builder().title(TILE1).build())
            .isNotEqualTo(Role.builder().title(TILE2).build());
    }
    
}
