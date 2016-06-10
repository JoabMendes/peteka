/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.QUser;
import br.edu.ifrn.peteka.dominio.Role;
import br.edu.ifrn.peteka.dominio.User;
import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author duartemac
 */
public class UserRepositoryImpl implements UserRepositoryCustom {
    
    private final EntityManager entityManager;

    @Inject
    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public List<User> getAllUsersOfRole(Role r) {
        QUser qUser = QUser.user;
        JPQLQueryFactory factory = new JPAQueryFactory(entityManager);

        List<User> users = (List<User>) factory
                .from(qUser)
                .where(qUser.role.eq(r))
                .fetch();
        return users;
    }    
}
