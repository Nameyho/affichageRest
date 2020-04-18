package com.affichageRest.affichageRest.Controller;

import com.affichageRest.affichageRest.DTO.*;
import com.affichageRest.affichageRest.model.Cours;
import com.affichageRest.affichageRest.model.Indisponibilite;
import com.affichageRest.affichageRest.services.CoursService;
import com.affichageRest.affichageRest.services.IndisponibiliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/indisponibilites")
public class IndisponibilitéController {

    @Autowired
    IndisponibiliteService indisponibiliteService;


    @GetMapping(value="/get")
    public ResponseEntity<List<IndisponibiliteGetDTO>> getAllPersonIndisponibilite(){
        return new ResponseEntity<>(indisponibiliteService.getAllCours(), HttpStatus.OK);
    }

    @GetMapping(value="/get/{id}")
    public ResponseEntity<IndisponibiliteGetDTO> getAllCours(@PathVariable(value="id") UUID id){
        return new ResponseEntity<>(indisponibiliteService.getIndisponibilite(id), HttpStatus.OK);
    }


    @PostMapping(value="/create")
    public ResponseEntity<UUID> createRole(@RequestBody IndisponibiliteCreateDTO ind){

        return new ResponseEntity<>(indisponibiliteService.createIndisponibilite(ind),HttpStatus.CREATED);
    }

    @PutMapping(value="/update/{id}")
    public void updateRole(@PathVariable(value="id") UUID id,
                           @RequestBody IndisponibiliteUpdateDTO indisponibiliteUpdateDTO){
        indisponibiliteService.updateIndisponibilite(id,indisponibiliteUpdateDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteRole(@PathVariable(value = "id") UUID id){
        indisponibiliteService.delete(id);

    }
}
