package com.affichageRest.affichageRest.DAO;


import com.affichageRest.affichageRest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);

}