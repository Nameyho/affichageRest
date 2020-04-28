package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.DTO.UserCreateDTO;
import com.affichageRest.affichageRest.DTO.UserGetDto;
import com.affichageRest.affichageRest.DTO.UserUpdateDto;
import com.affichageRest.affichageRest.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserGetDto> getAllUser();
    UUID CreateUser(UserCreateDTO userCreateDTO);
    UserGetDto getUser(UUID id);
    void updateUser(UUID id, UserUpdateDto userUpdateDto);
    void delete(UUID id);



    User findByUsername(String username);
}