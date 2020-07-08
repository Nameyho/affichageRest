package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.DTO.UserQueryDTO;
import com.affichageRest.affichageRest.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserQueryDTO> getAllUser();

    UUID CreateUser(UserQueryDTO userCreateDTO);

    UserQueryDTO getUser(UUID id);

    void updateUser(UUID id, UserQueryDTO userUpdateDto);

    void delete(UUID id);


    User findByUsername(String username);
}
