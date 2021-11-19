package ru.infinic.springbootadmin.service;

import ru.infinic.springbootadmin.model.Role;

import java.util.List;

/**
 * @author Oleg Kadochnikov
 */

public interface RoleService {
    void createRole(Role role);
    void deleteRole(Role role);
    void updateRole(Role role);
    Role getRoleById(Long id);
    Role getRoleByName(String name);
    List<Role> getAllRoles();
}
