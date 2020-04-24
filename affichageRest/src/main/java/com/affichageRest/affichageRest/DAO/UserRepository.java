package com.affichageRest.affichageRest.DAO;


import com.affichageRest.affichageRest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}