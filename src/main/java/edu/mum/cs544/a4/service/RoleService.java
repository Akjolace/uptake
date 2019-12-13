package edu.mum.cs544.a4.service;

import edu.mum.cs544.a4.entity.Role;

public interface RoleService {

    public Role addRole(Role role);

    public void deleteRole(long id);

    public Role findRoleByName(String rolename);

}