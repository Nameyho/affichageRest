package com.affichageRest.affichageRest.DAO;


import com.affichageRest.affichageRest.model.Roles;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RoleRepository extends CrudRepository<Roles, UUID> {
}
