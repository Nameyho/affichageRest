package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DAO.RoleRepository;
import com.affichageRest.affichageRest.DAO.UserRepository;
import com.affichageRest.affichageRest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {



      //  user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
         user.setPassword(user.getPassword());
        user.setRoles(user.getRoles());
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}