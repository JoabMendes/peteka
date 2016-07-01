/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.QUsers;
import br.edu.ifrn.peteka.dominio.Role;
import br.edu.ifrn.peteka.dominio.Users;
import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author duartemac
 */
public class UsersRepositoryImpl implements UsersRepositoryCustom {
    
    private final EntityManager entityManager;

    @Inject
    public UsersRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public List<Users> getAllUsersOfRole(Role r) {
        QUsers qUsers = QUsers.users;
        JPQLQueryFactory factory = new JPAQueryFactory(entityManager);

        List<Users> users = (List<Users>) factory
                .from(qUsers)
                .where(qUsers.role.eq(r))
                .fetch();
        return users;
    }    
}
