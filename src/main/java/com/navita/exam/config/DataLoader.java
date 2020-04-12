package com.navita.exam.config;

import com.navita.exam.role.Role;
import com.navita.exam.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    RoleService roleService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Role role = roleService.findById(1l);

        if (role == null) {
            role = new Role();

            role.setDescricao("user");

            roleService.create(role);
        }
    }
}
