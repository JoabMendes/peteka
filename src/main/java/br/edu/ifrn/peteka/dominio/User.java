/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.dominio;

import java.io.Serializable;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"nickname"})
@Builder
@Entity
@SequenceGenerator(sequenceName = "seq_user", name = "ID_SEQUENCE", allocationSize = 1)
public class User implements Serializable, Comparable<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_user_role"))
    private Role role;

    @Column(nullable = false)
    private Task task;

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String nickname;

    @Override
    public int compareTo(User o) {
        return nickname.compareTo(o.nickname);
    }
}
