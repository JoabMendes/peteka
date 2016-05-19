/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.dominio;

//import java.util.HashSet;
//import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author joab
 */
@Test
public class ProjectTest {
    
    private final String TITLE1 = "title1";
    private final String TITLE2 = "title2";
    private final String DESCRIPTION1 = "description1";
    private final String DESCRIPTION2 = "description2";
  
    public void equalTitles(){
        assertThat(Project.builder().title(TITLE1).build())
            .isEqualTo(Project.builder().title(TITLE1).build());
    }
    
    public void differentTitles(){
        assertThat(Project.builder().title(TITLE1).build())
            .isNotEqualTo(Project.builder().title(TITLE2).build());
    }
    
    public void equalTitlesDifferentDescriptions(){
        assertThat(Project.builder().title(TITLE1).description(DESCRIPTION1).build())
            .isNotEqualTo(Project.builder().title(TITLE1).description(DESCRIPTION2).build());
    }
    
    public void equalTitlesEqualDescriptions(){
        assertThat(Project.builder().title(TITLE1).description(DESCRIPTION1).build())
            .isEqualTo(Project.builder().title(TITLE1).description(DESCRIPTION1).build());
    }
    
    public void differentTitlesEqualDescriptions(){
        assertThat(Project.builder().title(TITLE1).description(DESCRIPTION1).build())
            .isNotEqualTo(Project.builder().title(TITLE2).description(DESCRIPTION1).build());
    }
    
    public void differentTitlesDifferentDescriptions(){
        assertThat(Project.builder().title(TITLE1).description(DESCRIPTION1).build())
            .isNotEqualTo(Project.builder().title(TITLE2).description(DESCRIPTION2).build());
    }

}
