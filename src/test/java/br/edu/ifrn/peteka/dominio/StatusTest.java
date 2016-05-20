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
public class StatusTest {
    
    private final String LABEL1 = "label1";
    private final String LABEL2 = "label2";
    
    public void equalLabels(){
        assertThat(Status.builder().label(LABEL1).build())
            .isEqualTo(Status.builder().label(LABEL1).build());
    }
    
    public void differentLabels(){
        assertThat(Status.builder().label(LABEL1).build())
            .isNotEqualTo(Status.builder().label(LABEL2).build());
    }
    
    
    public void compareToDifferentLabels(){
        Set<Status> statuses = new TreeSet<>();
        
        Status s1 = Status.builder().label(LABEL2).build();
        Status s2 = Status.builder().label(LABEL1).build();
        statuses.add(s1);
        statuses.add(s2);
        
        assertThat(statuses.iterator().next()).isEqualTo(s2);
    }
    
    
    
}
