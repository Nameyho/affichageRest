package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DAO.RoleRepository;


import com.affichageRest.affichageRest.DTO.RoleCreateDTO;
import com.affichageRest.affichageRest.DTO.RoleGetDTO;
import com.affichageRest.affichageRest.DTO.RoleUpdateDTO;
import com.affichageRest.affichageRest.model.Roles;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

import java.util.List;
import java.util.UUID;

@Service(value="RolesService")
public class RolesServiceImplement implements RolesService {

    @Resource
    private RoleRepository roleRepository;
    @Override
    public List<RoleGetDTO> getAllRoles() {
        List<RoleGetDTO> plist = new ArrayList<>();
        roleRepository.findAll().forEach(role -> {
            plist.add(new RoleGetDTO(role.getId(),role.getName(),role.getDescription()));
        });
        return plist;
    }

    @Override
    public RoleGetDTO getRole(UUID id) {
        if(roleRepository.findById(id).isPresent()){
            Roles  temp = roleRepository.findById(id).get();


            return new RoleGetDTO(temp.getId(),temp.getName(),temp.getDescription());
        }
        else{
            return null;
        }
    }

    @Override
    public UUID createRole(RoleCreateDTO role) {

        Roles newRoles = new Roles();

        newRoles.setIdRole(UUID.randomUUID());
        newRoles.setName(role.getName());
        newRoles.setDescription(role.getDescription());

        return roleRepository.save(newRoles).getId();
    }

    @Override
    public void updateRole(UUID id, RoleUpdateDTO role) {
        if (roleRepository.findById(id).isPresent()) {
            Roles roleexistant = roleRepository.findById(id).get();

            roleexistant.setDescription(role.getDescription());
            roleexistant.setName(role.getName());
            roleRepository.save(roleexistant);

        }

    }

    @Override
    public void delete(UUID id) {
        Roles role = this.roleRepository.findById(id).get();
        this.roleRepository.delete(role);
    }
}
