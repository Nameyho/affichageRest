package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.model.Roles;

import java.util.Collection;

public interface RolesService {

    Collection<Roles> getAllRoles();
    Roles getRole(Long id);
    Roles save(Roles role);
    Roles updateRole(Long id, Roles role);
    void delete(Long id);

}
