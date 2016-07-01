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
public class UsersTest {
    
    private static final String NICKNAME1 = "nickname1";
    private static final String NICKNAME2 = "nickname2";
    private static final String NAME1 = "nome1";
    private static final String NAME2 = "nome2";
    
    
    public void equalNicknames(){
        assertThat(Users.builder().nickname(NICKNAME1).build())
            .isEqualTo(Users.builder().nickname(NICKNAME1).build());
    }
    
    public void differentNicknames(){
        assertThat(Users.builder().nickname(NICKNAME1).build())
            .isNotEqualTo(Users.builder().nickname(NICKNAME2).build());
    }
    
    //Just to test if the exclude is working
    public void differentNicknamesSameNames(){
        assertThat(Users.builder().nickname(NICKNAME1).name(NAME1).build())
            .isNotEqualTo(Users.builder().nickname(NICKNAME2).name(NAME1).build());
    }
    
    //Just to test if the exclude is working
    public void sameNicknamesdifferentNames(){
        assertThat(Users.builder().nickname(NICKNAME1).name(NAME1).build())
            .isEqualTo(Users.builder().nickname(NICKNAME1).name(NAME2).build());
    }
    
    public void compareToDifferentNicknames(){
        Set<Users> users = new TreeSet<>();
        
        Users u1 = Users.builder().nickname(NICKNAME2).build();
        Users u2 = Users.builder().nickname(NICKNAME1).build();
        users.add(u1);
        users.add(u2);
        
        assertThat(users.iterator().next()).isEqualTo(u2);
    }
    
       
}
