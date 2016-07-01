/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.Role;
import br.edu.ifrn.peteka.dominio.Users;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author duartemac
 */
@Named
public class UsersFactory {
    // Users data
    public final static String USER_FRED = "FRED";
    public final static String USER_MIKE = "MIKE";
    public final static String USER_FRED_NAME = "FREDERICK";
    public final static String USER_MIKE_NAME = "MICHAEL";
    
    @Inject
    private UsersRepository userRepository;
    
    @Inject
    private RoleFactory roleFactory;
    
    private Users user(String nickname, String name, Role r) {
        Users user = this.userRepository.findByNickname(nickname);
        
        if (user == null) {
            user = Users.builder()
                .nickname(nickname)
                .name(name)
                .role(r)
                .build();

            this.userRepository.save(user);
        }
        
        return user;
    }
    
    public Users user (Role r) {
        return user(USER_MIKE, USER_MIKE_NAME, r);
    }
    
    public Users fred () {
        Role admin = roleFactory.admin();
        return user(USER_MIKE, USER_MIKE_NAME, admin);
    }
    
    public Users mike () {
        Role manager = roleFactory.manager();
        return user(USER_MIKE, USER_MIKE_NAME, manager);
    }
}
