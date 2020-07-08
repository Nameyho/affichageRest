package com.affichageRest.affichageRest.Controller;


import com.affichageRest.affichageRest.DTO.EcranResultatQueryDTO;
import com.affichageRest.affichageRest.model.EcranResultatID;
import com.affichageRest.affichageRest.services.EcranResultatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@CrossOrigin
@RestController
@RequestMapping(value = "/ecranresultat")
public class EcranresultatController {

    @Autowired
    private EcranResultatService ecranResultatService;


    @GetMapping
    public ResponseEntity<List<EcranResultatQueryDTO>> getAllCours() {
        return new ResponseEntity<>(ecranResultatService.getAllEcranresultat(), HttpStatus.OK);
    }

    @GetMapping(value = "/{idecran}/{idcours}")
    public ResponseEntity<EcranResultatQueryDTO> getEcranByID(
            @PathVariable(value = "idecran") UUID idecran,
            @PathVariable(value = "idcours") UUID idcours

    ) {

        EcranResultatID ecranResultatID = new EcranResultatID(
                idecran,
                idcours
        );

        return new ResponseEntity<>(ecranResultatService.getEcranResultat(ecranResultatID),
                HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<UUID> createresultatEcran(@RequestBody EcranResultatQueryDTO ecranResultatQueryDTO) {
        return new ResponseEntity(ecranResultatService.createEcranResultat(ecranResultatQueryDTO), HttpStatus.CREATED);
    }

//    @PutMapping(value = "/{idecran}/{idcours}")
//    public void UpdateAbsenceEcran(
//            @PathVariable(value = "idecran") UUID idecran,
//            @PathVariable(value = "idcours") UUID idcours,
//            @RequestBody EcranResultatQueryDTO ecranResultatQueryDTO) {
//
//        EcranResultatID ecranResultatID = new EcranResultatID(
//                idecran,
//                idcours
//        );
//
//        ecranResultatService.updateEcranResultat(ecranResultatID, ecranResultatQueryDTO);
//    }

    @DeleteMapping(value = "/{idecran}/{idcours}")
    public void deleteAbsenceEcran(
            @PathVariable(value = "idecran") UUID idecran,
            @PathVariable(value = "idcours") UUID idcours
    ) {

        EcranResultatID ecranResultatID = new EcranResultatID(
                idecran,
                idcours
        );
        ecranResultatService.delete(ecranResultatID);

    }
}
