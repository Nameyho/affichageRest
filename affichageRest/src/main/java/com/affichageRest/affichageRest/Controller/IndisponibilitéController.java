package com.affichageRest.affichageRest.Controller;

import com.affichageRest.affichageRest.DTO.IndisponibiliteQueryDTO;
import com.affichageRest.affichageRest.services.IndisponibiliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping(value = "/indisponibilites")
public class IndisponibilitéController {

    @Autowired
    IndisponibiliteService indisponibiliteService;


    @GetMapping
    public ResponseEntity<List<IndisponibiliteQueryDTO>> getAllPersonIndisponibilite(){
        return new ResponseEntity<>(indisponibiliteService.getAllCours(), HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<IndisponibiliteQueryDTO> getAllCours(@PathVariable(value="id") UUID id){
        return new ResponseEntity<>(indisponibiliteService.getIndisponibilite(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<UUID> createRole(@RequestBody IndisponibiliteQueryDTO ind){

        return new ResponseEntity<>(indisponibiliteService.createIndisponibilite(ind),HttpStatus.CREATED);
    }

    @PutMapping(value="/{id}")
    public void updateRole(@PathVariable(value="id") UUID id,
                           @RequestBody IndisponibiliteQueryDTO indisponibiliteUpdateDTO){
        indisponibiliteService.updateIndisponibilite(id,indisponibiliteUpdateDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteRole(@PathVariable(value = "id") UUID id){
        indisponibiliteService.delete(id);

    }
}
