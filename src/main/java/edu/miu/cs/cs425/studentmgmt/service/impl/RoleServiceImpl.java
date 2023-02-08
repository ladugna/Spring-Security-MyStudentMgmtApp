package edu.miu.cs.cs425.studentmgmt.service.impl;

import edu.miu.cs.cs425.studentmgmt.model.Role;
import edu.miu.cs.cs425.studentmgmt.repository.RoleRepository;
import edu.miu.cs.cs425.studentmgmt.service.RoleService;
import org.springframework.data.domain.Sort;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll(Sort.by("name"));
    }
}
