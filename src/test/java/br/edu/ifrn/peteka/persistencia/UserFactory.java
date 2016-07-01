/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.Role;
import br.edu.ifrn.peteka.dominio.User;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author duartemac
 */
@Named
public class UserFactory {
    // User data
    public final static String USER_FRED = "FRED";
    public final static String USER_MIKE = "MIKE";
    public final static String USER_FRED_NAME = "FREDERICK";
    public final static String USER_MIKE_NAME = "MICHAEL";
    
    @Inject
    private UserRepository userRepository;
    
    @Inject
    private RoleFactory roleFactory;
    
    private User user(String nickname, String name, Role r) {
        User user = this.userRepository.findByNickname(nickname);
        
        if (user == null) {
            user = User.builder()
                .nickname(nickname)
                .name(name)
                .role(r)
                .build();

            this.userRepository.save(user);
        }
        
        return user;
    }
    
    public User user (Role r) {
        return user(USER_MIKE, USER_MIKE_NAME, r);
    }
    
    public User fred () {
        Role admin = roleFactory.admin();
        return user(USER_MIKE, USER_MIKE_NAME, admin);
    }
    
    public User mike () {
        Role manager = roleFactory.manager();
        return user(USER_MIKE, USER_MIKE_NAME, manager);
    }
}
