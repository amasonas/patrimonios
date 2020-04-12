package com.navita.exam.role.service;

import com.navita.exam.role.Role;

public interface RoleService {

    Role create(Role role);

    Role findById(Long id);
}
