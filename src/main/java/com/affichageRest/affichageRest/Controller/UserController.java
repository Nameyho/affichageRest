package com.affichageRest.affichageRest.Controller;

import com.affichageRest.affichageRest.DTO.UserQueryDTO;
import com.affichageRest.affichageRest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<UserQueryDTO>> getAllUser() {


        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserQueryDTO> getUser(@PathVariable(value = "id") UUID id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);

    }


    @PostMapping
    public ResponseEntity<UUID> createUser(@RequestBody UserQueryDTO user) {

        return new ResponseEntity<>(userService.CreateUser(user), HttpStatus.CREATED);
    }


    @PutMapping(value = "/{id}")
    public void updateUser(@PathVariable(value = "id") UUID id,
                           @RequestBody UserQueryDTO UserQueryDTO) {
        userService.updateUser(id, UserQueryDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable(value = "id") UUID id) {
        userService.delete(id);


    }

    @RequestMapping("/login")
    public Map<String, Object> home() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }

}
