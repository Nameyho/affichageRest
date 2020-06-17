package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DTO.RoleQueryDTO;

import java.util.List;
import java.util.UUID;

public interface RolesService {

    List<RoleQueryDTO> getAllRoles();
    UUID createRole(RoleQueryDTO roleCreateDTO);
    RoleQueryDTO getRole(UUID id);
    void updateRole(UUID id, RoleQueryDTO role);
    void delete(UUID id);

}
