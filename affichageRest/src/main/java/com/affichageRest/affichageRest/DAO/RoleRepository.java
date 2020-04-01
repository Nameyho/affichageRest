package com.affichageRest.affichageRest.DAO;


import com.affichageRest.affichageRest.model.Roles;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Roles,Long> {
}
