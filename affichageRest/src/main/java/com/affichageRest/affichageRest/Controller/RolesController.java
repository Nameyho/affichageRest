package com.affichageRest.affichageRest.Controller;

import com.affichageRest.affichageRest.DTO.RoleCreateDTO;
import com.affichageRest.affichageRest.DTO.RoleGetDTO;
import com.affichageRest.affichageRest.DTO.RoleUpdateDTO;
import com.affichageRest.affichageRest.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping(value = "/roles")
public class RolesController {

    @Autowired
    private  RolesService rolesService;


    @GetMapping
   public ResponseEntity<List<RoleGetDTO>> getAllRoles(){
        return new ResponseEntity<>(rolesService.getAllRoles(), HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<RoleGetDTO> getAllRoles(@PathVariable(value="id") UUID id){
        return new ResponseEntity<>(rolesService.getRole(id), HttpStatus.OK);
    }


    @PostMapping
         public ResponseEntity<UUID> createRole(@RequestBody RoleCreateDTO role){

        return new ResponseEntity<>(rolesService.createRole(role),HttpStatus.CREATED);
    }

    @PutMapping(value="/{id}")
    public void updateRole(@PathVariable(value="id") UUID id,
                             @RequestBody RoleUpdateDTO roleUpdateDTO){
        rolesService.updateRole(id,roleUpdateDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteRole(@PathVariable(value = "id") UUID id){
        rolesService.delete(id);

    }
}
