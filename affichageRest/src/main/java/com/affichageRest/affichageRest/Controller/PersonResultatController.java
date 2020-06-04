package com.affichageRest.affichageRest.Controller;



import com.affichageRest.affichageRest.DTO.*;
import com.affichageRest.affichageRest.model.PersonResultat;
import com.affichageRest.affichageRest.model.PersonResultatPK;
import com.affichageRest.affichageRest.services.PersonResultatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/resultat")

public class PersonResultatController {

    @Autowired
    private PersonResultatService personresultat;

    @GetMapping
    public ResponseEntity<List<PersonResultatGetDTO>> getAllResultat(){
        return new ResponseEntity<>(personresultat.getAllResultat(), HttpStatus.OK);

    }

    @GetMapping(value ="/{idperson}/{idcours}")
    public ResponseEntity<PersonResultatGetDTO> getresultat(@PathVariable(value="idperson")  UUID idperson,@PathVariable(value = "idcours") UUID idcours){
       PersonResultatPK id = new PersonResultatPK(idperson,idcours);



        return new ResponseEntity<>(personresultat.getPersonResultat(id),HttpStatus.OK);

    }

    @GetMapping(value = "/{idperson}")
    public ResponseEntity<PersonResultatGetDTO> getResultatPersonne(@PathVariable(value = "idperson")UUID idperson){
        return new ResponseEntity(personresultat.getResultatbyPerson(idperson),HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<UUID>createPerson(@RequestBody PersonResultatCreateDTO res){

        return new ResponseEntity(personresultat.createResultat(res), HttpStatus.CREATED);
    }


    @PutMapping(value ="/{idperson}/{idcours")
    public void updatePerson(@PathVariable(value="idperson")  UUID idperson,@PathVariable(value = "idcours") UUID idcours ,
                             @RequestBody PersonResultatUpdateDTO personUpdateDTO){
        PersonResultatPK id = new PersonResultatPK(idperson,idcours);
        personresultat.updateResultat(id,personUpdateDTO);
    }

    @DeleteMapping(value ="/{idperson}/{idcours")
    public void deletePerson(@PathVariable(value="idperson")  UUID idperson,@PathVariable(value = "idcours") UUID idcours ){
        PersonResultatPK id = new PersonResultatPK(idperson,idcours);
        personresultat.delete(id);

    }
}
