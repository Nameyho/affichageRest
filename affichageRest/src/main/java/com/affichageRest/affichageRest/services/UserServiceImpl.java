package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DAO.RoleRepository;
import com.affichageRest.affichageRest.DAO.UserRepository;
import com.affichageRest.affichageRest.DTO.UserQueryDTO;
import com.affichageRest.affichageRest.model.Role;
import com.affichageRest.affichageRest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;





    @Override
    public UUID CreateUser(UserQueryDTO user) {

        User nouvUser = new User();

        nouvUser.setIdUser(UUID.randomUUID());
        nouvUser.setUsername(user.getUsername());

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String mdpenc =  bCryptPasswordEncoder.encode(user.getPassword());

        nouvUser.setPassword(mdpenc);

        Role role = roleRepository.findById(user.getId()).get();

        nouvUser.setRoles(role);
        return userRepository.save(nouvUser).getIdUser();
    }

    @Override
    public List<UserQueryDTO> getAllUser() {
        List<UserQueryDTO> plist= new ArrayList<>();
        userRepository.findAll().forEach(user->
                plist.add(new UserQueryDTO(
                        user.getIdUser(),

                        user.getUsername(),
                        user.getPassword(),
                        user.getRoles().getIdRole()

                ))

        );
        return plist;
    }


    @Override
    public UserQueryDTO getUser(UUID id) {
        if(userRepository.findById(id).isPresent()){
            User user = userRepository.findById(id).get();

            return new UserQueryDTO(user.getIdUser(),user.getUsername(),user.getPassword(),user.getRoles().getIdRole());

        }
        else{
            return null;
        }
    }

    @Override
    public void updateUser(UUID id, UserQueryDTO userUpdateDto) {

        if(userRepository.findById(id).isPresent()){

            User user =userRepository.findById(id).get();

            user.setUsername(userUpdateDto.getUsername());


                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


            user.setPassword(bCryptPasswordEncoder.encode(userUpdateDto.getPassword()));

            Role role = roleRepository.findById(userUpdateDto.getId()).get();

            user.setRoles(role);

            userRepository.save(user);


        }

    }

    @Override
    public void delete(UUID id) {

        User user = this.userRepository.findById(id).get();
        this.userRepository.delete(user);

    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
