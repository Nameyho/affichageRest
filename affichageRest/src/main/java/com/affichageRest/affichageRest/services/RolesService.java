package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.model.Roles;

import java.util.Collection;

public interface RolesService {

    Collection<Roles> getAllRoles();
    Roles getRoles(Long id);
    Roles save(Roles role);
    Roles updateRoles(Long id, Roles role);
    void delete(Long id);

}
