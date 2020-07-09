package com.affichageRest.affichageRest.Controller;


import com.affichageRest.affichageRest.DTO.EcranMessageQueryDTO;
import com.affichageRest.affichageRest.DTO.EcranResultatQueryDTO;
import com.affichageRest.affichageRest.model.EcranMessageID;
import com.affichageRest.affichageRest.model.EcranResultatID;
import com.affichageRest.affichageRest.services.EcranMessageService;
import com.affichageRest.affichageRest.services.EcranResultatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@CrossOrigin
@RestController
@RequestMapping(value = "/ecranmessage")
public class EcranMessageController {

    @Autowired
    private EcranMessageService ecranMessageService;


    @GetMapping
    public ResponseEntity<List<EcranMessageQueryDTO>> getAllCours() {
        return new ResponseEntity<>(ecranMessageService.getAllEcranMessage(), HttpStatus.OK);
    }

    @GetMapping(value = "/{idecran}/{idmessage}")
    public ResponseEntity<EcranMessageQueryDTO> getEcranByID(
            @PathVariable(value = "idecran") UUID idecran,
            @PathVariable(value = "idmessage") UUID idmessage

    ) {

        EcranMessageID ecranMessageID = new EcranMessageID(
                idecran,
                idmessage
        );

        return new ResponseEntity<>(ecranMessageService.getEcranMessage(ecranMessageID),
                HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<UUID> createresultatEcran(@RequestBody EcranMessageQueryDTO ecranMessageQueryDTO) {
        return new ResponseEntity(ecranMessageService.createEcranMessage(ecranMessageQueryDTO), HttpStatus.CREATED);
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

    @DeleteMapping(value = "/{idecran}/{idmessage}")
    public void deleteAbsenceEcran(
            @PathVariable(value = "idecran") UUID idecran,
            @PathVariable(value = "idmessage") UUID idmessage
    ) {

        EcranMessageID ecranMessageID = new EcranMessageID(
                idecran,
                idmessage
        );
        ecranMessageService.delete(ecranMessageID);

    }
}
