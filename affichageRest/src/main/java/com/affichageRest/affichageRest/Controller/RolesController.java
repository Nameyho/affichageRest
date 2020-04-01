package com.affichageRest.affichageRest.Controller;

import com.affichageRest.affichageRest.model.Messages;
import com.affichageRest.affichageRest.model.Roles;
import com.affichageRest.affichageRest.services.RolesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@RequestMapping(value = "/roles")
public class RolesController {

    @Resource
    RolesService rolesService;


    @GetMapping
   public Collection getAllRoles(){
        return this.rolesService.getAllRoles();
    }



    @PostMapping(value="/create")
         Roles Createrole(@RequestBody Roles roles){

        return this.rolesService.save(roles);
    }
}
