package com.affichageRest.affichageRest.Controller;


import com.affichageRest.affichageRest.DTO.EcranAbsenceQueryDTO;
import com.affichageRest.affichageRest.DTO.EcranMessageQueryDTO;
import com.affichageRest.affichageRest.model.EcranAbsenceID;
import com.affichageRest.affichageRest.model.PersonIndisponibilitePK;
import com.affichageRest.affichageRest.services.EcranAbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@CrossOrigin
@RestController
@RequestMapping(value = "/ecranabsence")
public class EcranAbsenceController {

    @Autowired
    private EcranAbsenceService ecranAbsenceService;


    @GetMapping
    public ResponseEntity<List<EcranAbsenceQueryDTO>> getAllCours() {
        return new ResponseEntity<>(ecranAbsenceService.getAllEcran(), HttpStatus.OK);
    }

    @GetMapping(value = "/{idecran}/{idperson}/{idindispo}/{idspecifique}")
    public ResponseEntity<EcranAbsenceQueryDTO> getEcranByID(
            @PathVariable(value = "idecran") UUID idecran,
            @PathVariable(value = "idperson") UUID idperson,
            @PathVariable(value = "idindispo") UUID idindispo,
            @PathVariable(value = "idspecifique") UUID idspecifique
    ) {

        EcranAbsenceID ecranAbsenceID = new EcranAbsenceID(
                idecran,
                new PersonIndisponibilitePK(
                        idperson, idindispo, idspecifique
                )
        );

        return new ResponseEntity<>(ecranAbsenceService.getEcranAbsence(ecranAbsenceID),
                HttpStatus.OK);
    }

    @GetMapping(value = "/{idecran}")
    public ResponseEntity<List<EcranAbsenceQueryDTO>> getAllMessagesbyecran(@PathVariable(value = "idecran") UUID idecran) {
        return new ResponseEntity<>(ecranAbsenceService.findAllByEcranAbsenceID_IdEcran(idecran), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UUID> createAbsenceEcran(@RequestBody @Valid EcranAbsenceQueryDTO ecranAbsenceQueryDTO) {
        return new ResponseEntity(ecranAbsenceService.createEcranAbsence(ecranAbsenceQueryDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{idecran}/{idperson}/{idindispo}/{idspecifique}")
    public void UpdateAbsenceEcran(
            @PathVariable(value = "idecran") UUID idecran,
            @PathVariable(value = "idperson") UUID idperson,
            @PathVariable(value = "idindispo") UUID idindispo,
            @PathVariable(value = "idspecifique") UUID idspecifique,
            @RequestBody EcranAbsenceQueryDTO ecranAbsenceQueryDTO) {

        EcranAbsenceID ecranAbsenceID = new EcranAbsenceID(
                idecran,
                new PersonIndisponibilitePK(
                        idperson, idindispo, idspecifique
                )
        );

        ecranAbsenceService.updateEcranAbsence(ecranAbsenceID, ecranAbsenceQueryDTO);
    }

    @DeleteMapping(value = "/{idecran}/{idperson}/{idindispo}/{idspecifique}")
    public void deleteAbsenceEcran(
            @PathVariable(value = "idecran") UUID idecran,
            @PathVariable(value = "idperson") UUID idperson,
            @PathVariable(value = "idindispo") UUID idindispo,
            @PathVariable(value = "idspecifique") UUID idspecifique) {

        EcranAbsenceID ecranAbsenceID = new EcranAbsenceID(
                idecran,
                new PersonIndisponibilitePK(
                        idperson, idindispo, idspecifique
                )
        );
        ecranAbsenceService.delete(ecranAbsenceID);

    }
}
