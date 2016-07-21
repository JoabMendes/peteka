/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.peteka.persistencia;

import br.edu.ifrn.peteka.dominio.Role;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author duartemac
 */
@Named
public class RoleFactory {

    // Role data
    public final static String ROLE_ADMIN = "ADMIN";
    public final static String ROLE_MANAGER = "MANAGER";

    @Inject
    private RoleRepository roleRepository;

    public String getROLE_ADMIN() {
        return ROLE_ADMIN;
    }

    public String getROLE_MANAGER() {
        return ROLE_MANAGER;
    }

    private Role role(String title) {
        Role role = this.roleRepository.findByTitle(title);

        if (role == null) {
            role = Role.builder()
                    .title(title)
                    .build();

            this.roleRepository.save(role);
        }

        return role;
    }

    public Role admin() {
        return role(ROLE_ADMIN);
    }

    public Role manager() {
        return role(ROLE_MANAGER);
    }
}
