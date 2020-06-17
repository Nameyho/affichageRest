package com.affichageRest.affichageRest.Controller;


import com.affichageRest.affichageRest.DTO.CoursEnseigneQueryDTO;
import com.affichageRest.affichageRest.DTO.PersonResultatQueryDTO;
import com.affichageRest.affichageRest.model.CoursEnseigneID;
import com.affichageRest.affichageRest.services.CoursEnseigneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/coursEns")

public class CoursEnsController {

    @Autowired
    private CoursEnseigneService coursEnseigneService;

    @GetMapping
    public ResponseEntity<List<CoursEnseigneQueryDTO>> getAllCoursEnseigne(){
        return new ResponseEntity<>(coursEnseigneService.getAllCoursEnseignes(), HttpStatus.OK);

    }

    @GetMapping(value ="/{idperson}/{idcours}")
    public ResponseEntity<PersonResultatQueryDTO> getCoursEnseigne(@PathVariable(value="idperson")  UUID idperson, @PathVariable(value = "idcours") UUID idcours){
        CoursEnseigneID id = new CoursEnseigneID(idperson,idcours);

        return new ResponseEntity(coursEnseigneService.getCoursEnseigne(id),HttpStatus.OK);

    }



    @PostMapping
    public ResponseEntity<UUID>createCoursens(@RequestBody CoursEnseigneQueryDTO res){

        return new ResponseEntity(coursEnseigneService.createCoursEnseigne(res), HttpStatus.CREATED);
    }


    @PutMapping(value ="/{idperson}/{idcours}")
    public void updatePerson(@PathVariable(value="idperson")  UUID idperson,@PathVariable(value = "idcours") UUID idcours ,
                             @RequestBody CoursEnseigneQueryDTO coursEnseigneUpdateDTO){
        CoursEnseigneID id = new CoursEnseigneID(idperson,idcours);
        coursEnseigneService.updateCoursEnseigne(id,coursEnseigneUpdateDTO);
    }

    @DeleteMapping(value ="/{idperson}/{idcours")
    public void deletePerson(@PathVariable(value="idperson")  UUID idperson,@PathVariable(value = "idcours") UUID idcours ){
        CoursEnseigneID id = new CoursEnseigneID(idperson,idcours);
        coursEnseigneService.delete(id);

    }
}
