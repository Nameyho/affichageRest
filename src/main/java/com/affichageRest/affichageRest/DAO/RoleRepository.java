package com.affichageRest.affichageRest.DAO;


import com.affichageRest.affichageRest.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
}
