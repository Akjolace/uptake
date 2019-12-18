package edu.mum.cs544.a4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.a4.entity.Role;
import edu.mum.cs544.a4.repository.RoleRepository;
import edu.mum.cs544.a4.service.RoleService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    @Transactional
    public void deleteRole(long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role findRoleByName(String rolename) {
        return roleRepository.findByRoleName(rolename);
    }
    
}