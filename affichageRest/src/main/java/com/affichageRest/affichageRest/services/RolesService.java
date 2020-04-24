package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DTO.RoleCreateDTO;
import com.affichageRest.affichageRest.DTO.RoleGetDTO;
import com.affichageRest.affichageRest.DTO.RoleUpdateDTO;


import java.util.List;
import java.util.UUID;

public interface RolesService {

    List<RoleGetDTO> getAllRoles();
    UUID createRole(RoleCreateDTO roleCreateDTO);
    RoleGetDTO getRole(UUID id);
    void updateRole(UUID id, RoleUpdateDTO role);
    void delete(UUID id);

}
