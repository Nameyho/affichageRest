package com.affichageRest.affichageRest.Controller;

import com.affichageRest.affichageRest.DTO.PersonCreateDTO;
import com.affichageRest.affichageRest.DTO.PersonUpdateDTO;
import com.affichageRest.affichageRest.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {

    @Autowired
    private PersonService personService;



    @PostMapping(value = "/create")
    public ResponseEntity<UUID>createPerson(@RequestBody PersonCreateDTO person){

        return new ResponseEntity<>(personService.createPerson(person), HttpStatus.CREATED);
    }
    @PutMapping(value="/update/{id}")
    public void updatePerson(@PathVariable(value="id") UUID id,
                                       @RequestBody PersonUpdateDTO personUpdateDTO){
        personService.updatePerson(id,personUpdateDTO);
    }
}
