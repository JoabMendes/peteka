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
public class UserTest {
    
    private final String NICKNAME1 = "nickname1";
    private final String NICKNAME2 = "nickname2";
    private final String NAME1 = "nome1";
    private final String NAME2 = "nome2";
    
    
    public void equalNicknames(){
        assertThat(User.builder().nickname(NICKNAME1).build())
            .isEqualTo(User.builder().nickname(NICKNAME1).build());
    }
    
    public void differentNicknames(){
        assertThat(User.builder().nickname(NICKNAME1).build())
            .isNotEqualTo(User.builder().nickname(NICKNAME2).build());
    }
    
    //Just to test if the exclude is working
    public void differentNicknamesSameNames(){
        assertThat(User.builder().nickname(NICKNAME1).name(NAME1).build())
            .isNotEqualTo(User.builder().nickname(NICKNAME2).name(NAME1).build());
    }
    
    //Just to test if the exclude is working
    public void sameNicknamesdifferentNames(){
        assertThat(User.builder().nickname(NICKNAME1).name(NAME1).build())
            .isEqualTo(User.builder().nickname(NICKNAME1).name(NAME2).build());
    }
    
    public void compareToDifferentNicknames(){
        Set<User> users = new TreeSet<>();
        
        User u1 = User.builder().nickname(NICKNAME2).build();
        User u2 = User.builder().nickname(NICKNAME1).build();
        users.add(u1);
        users.add(u2);
        
        assertThat(users.iterator().next()).isEqualTo(u2);
    }
    
       
}
