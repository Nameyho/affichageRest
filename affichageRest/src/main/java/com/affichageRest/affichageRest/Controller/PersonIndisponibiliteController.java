package com.affichageRest.affichageRest.Controller;


import com.affichageRest.affichageRest.DTO.*;
import com.affichageRest.affichageRest.model.PersonIndisponibilite;
import com.affichageRest.affichageRest.model.PersonIndisponibilitePK;
import com.affichageRest.affichageRest.model.PersonResultatPK;
import com.affichageRest.affichageRest.services.PersonIndisponibiliteService;
import com.affichageRest.affichageRest.services.PersonResultatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceProperty;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/indisponibilite")

public class PersonIndisponibiliteController {

    @Autowired
    private PersonIndisponibiliteService personIndisponibiliteService;

    @GetMapping
    public ResponseEntity<List<PersonIndisponibiliteGetDTO>> getAllindispo(){
        return new ResponseEntity<>(personIndisponibiliteService.getAllPersonIndisponibilite(), HttpStatus.OK);

    }

    @GetMapping(value ="/{idperson}/{idindispo}/{idcours}")
    public ResponseEntity<PersonIndisponibiliteGetDTO> getindispo(@PathVariable(value="idperson")  UUID idperson,@PathVariable(value = "idcours")
            UUID idcours,@PathVariable(value="idindispo")  UUID idindispo){
       PersonIndisponibilitePK id = new PersonIndisponibilitePK(idperson,idindispo,idcours);



        return new ResponseEntity<>(personIndisponibiliteService.getPersonIndisponibilite(id),HttpStatus.OK);

    }



    @PostMapping
    public ResponseEntity<UUID>createIndispo(@RequestBody PersonIndisponibiliteCreateDTO res){

        return new ResponseEntity(personIndisponibiliteService.createPersonIndisponibilite(res), HttpStatus.CREATED);
    }


    @PutMapping(value ="/{idperson}/{idindispo}/{idcours}")
    public void updateindispo(@PathVariable(value="idperson")  UUID idperson,@PathVariable(value = "idcours") UUID idcours ,
                             @PathVariable(value = "idinspo") UUID idindispo,
                             @RequestBody PersonIndisponibiliteUpdateDTO personIndisponibiliteUpdateDTO){
        PersonIndisponibilitePK id = new PersonIndisponibilitePK(idperson,idindispo,idcours);
        personIndisponibiliteService.updatePersonIndisponibilite(id,personIndisponibiliteUpdateDTO);
    }

    @DeleteMapping(value ="/{idperson}/{idindispo}/{idcours}")
    public void deleteIndispo(@PathVariable(value="idperson")  UUID idperson,@PathVariable(value = "idcours") UUID idcours ,
                              @PathVariable(value = "idinspo") UUID idindispo){
        PersonIndisponibilitePK id = new PersonIndisponibilitePK(idperson,idindispo,idcours);
        personIndisponibiliteService.delete(id);

    }
}
