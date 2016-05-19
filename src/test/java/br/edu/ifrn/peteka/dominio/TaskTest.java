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
public class TaskTest {
    
    private final String TILE1 = "tile1";
    private final String TILE2 = "title2";
    
    
    public void equalTitles(){
        assertThat(Task.builder().title(TILE1).build())
            .isEqualTo(Task.builder().title(TILE1).build());
    }
    
    public void differentTitles(){
        assertThat(Task.builder().title(TILE1).build())
            .isNotEqualTo(Task.builder().title(TILE2).build());
    }
    
    public void equalTitlesDifferentDescription(){
        assertThat(Task.builder().title(TILE1).description("D1").build())
            .isEqualTo(Task.builder().title(TILE1).description("D2").build());
    }
    
    public void differentTitlesEqualDescription(){
        assertThat(Task.builder().title(TILE1).description("D1").build())
            .isNotEqualTo(Task.builder().title(TILE2).description("D1").build());
    }
    
}
