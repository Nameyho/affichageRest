package com.affichageRest.affichageRest.DAO;



import org.springframework.data.jpa.repository.JpaRepository;
import com.affichageRest.affichageRest.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}