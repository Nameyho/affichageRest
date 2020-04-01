package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DAO.RoleRepository;

import com.affichageRest.affichageRest.model.Person;
import com.affichageRest.affichageRest.model.Roles;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

@Service(value="RolesService")
public class RolesServiceImplement implements RolesService {

    @Resource
    private RoleRepository roleRepository;
    @Override
    public Collection<Roles> getAllRoles() {
        return (Collection<Roles>) roleRepository.findAll();
    }

    @Override
    public Roles getRoles(Long id) {
        return this.roleRepository.findById(id).get();
    }

    @Override
    public Roles save(Roles roles) {
        return this.roleRepository.save(roles);
    }

    @Override
    public Roles updateRoles(Long id, Roles role) {
        //mettre à jour plus tard
        return this.roleRepository.save(role);
    }

    @Override
    public void delete(Long id) {
        Roles role = this.roleRepository.findById(id).get();
        this.roleRepository.delete(role);
    }
}
