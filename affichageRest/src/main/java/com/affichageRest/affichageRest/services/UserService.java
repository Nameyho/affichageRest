package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}