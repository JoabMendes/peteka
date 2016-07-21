/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.dominio;

import java.util.Set;
import java.util.TreeSet;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author joab
 */
@Test
public class TaskTest {

    private static final String TITLE1 = "title1";
    private static final String TITLE2 = "title2";
    private static final String D1 = "D1";
    private static final String D2 = "D2";

    public void equalTitles() {
        assertThat(Task.builder().title(TITLE1).build())
                .isEqualTo(Task.builder().title(TITLE1).build());
    }

    public void differentTitles() {
        assertThat(Task.builder().title(TITLE1).build())
                .isNotEqualTo(Task.builder().title(TITLE2).build());
    }

    //Just to test if the exclude is working
    public void equalTitlesDifferentDescription() {
        assertThat(Task.builder().title(TITLE1).description(D1).build())
                .isEqualTo(Task.builder().title(TITLE1).description(D2).build());
    }

    //Just to test if the exclude is working
    public void differentTitlesEqualDescription() {
        assertThat(Task.builder().title(TITLE1).description(D1).build())
                .isNotEqualTo(Task.builder().title(TITLE2).description(D1).build());
    }

    public void compareToDifferentTitles() {
        Set<Task> tasks = new TreeSet<>();

        Task t1 = Task.builder().title(TITLE2).build();
        Task t2 = Task.builder().title(TITLE1).build();
        tasks.add(t1);
        tasks.add(t2);

        assertThat(tasks.iterator().next()).isEqualTo(t2);
    }

}
