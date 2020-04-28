package com.affichageRest.affichageRest.Controller;

import com.affichageRest.affichageRest.DTO.UserCreateDTO;
import com.affichageRest.affichageRest.DTO.UserGetDto;
import com.affichageRest.affichageRest.DTO.UserUpdateDto;
import com.affichageRest.affichageRest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;




    @GetMapping
    public ResponseEntity<List<UserGetDto>> getAllUser(){




        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);

    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<UserGetDto> getUser(@PathVariable(value="id") UUID id){
        return new ResponseEntity<>(userService.getUser(id),HttpStatus.OK);

    }



    @PostMapping
    public ResponseEntity<UUID>createUser(@RequestBody UserCreateDTO user){

        return new ResponseEntity<>(userService.CreateUser(user), HttpStatus.CREATED);
    }


    @PutMapping(value="/{id}")
    public void updateUser(@PathVariable(value="id") UUID id,
                                       @RequestBody UserUpdateDto userUpdateDto){
        userService.updateUser(id,userUpdateDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable(value = "id") UUID id){
       userService.delete(id);

}}
