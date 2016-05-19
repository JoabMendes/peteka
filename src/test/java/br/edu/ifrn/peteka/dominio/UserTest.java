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
public class UserTest {
    
    private final String NICKNAME1 = "nome1";
    private final String NICKNAME2 = "nome2";
    
    
    public void equalNicknames(){
        assertThat(User.builder().nickname(NICKNAME1).build())
            .isEqualTo(User.builder().nickname(NICKNAME1).build());
    }
    
    public void differentNicknames(){
        assertThat(User.builder().nickname(NICKNAME1).build())
            .isNotEqualTo(User.builder().nickname(NICKNAME2).build());
    }
    
    public void differentNicknamesSameNames(){
        assertThat(User.builder().nickname(NICKNAME1).name("name").build())
            .isNotEqualTo(User.builder().nickname(NICKNAME2).name("name").build());
    }
    
    public void sameNicknamesdifferentNames(){
        assertThat(User.builder().nickname(NICKNAME1).name("name").build())
            .isEqualTo(User.builder().nickname(NICKNAME1).name("name 2").build());
    }
    
       
}
