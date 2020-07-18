package com.affichageRest.affichageRest.Controller;


import com.affichageRest.affichageRest.DTO.EcranAbsenceQueryDTO;
import com.affichageRest.affichageRest.DTO.EcranQueryDTO;
import com.affichageRest.affichageRest.model.EcranAbsenceID;
import com.affichageRest.affichageRest.model.PersonIndisponibilitePK;
import com.affichageRest.affichageRest.services.EcranAbsenceService;
import com.affichageRest.affichageRest.services.EcranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@CrossOrigin
@RestController
@RequestMapping(value = "/ecrans")
public class EcranController {

    @Autowired
    private EcranService ecranService;


    @GetMapping
    public ResponseEntity<List<EcranQueryDTO>> getAllEcran() {
        return new ResponseEntity<>(ecranService.getAllEcran(), HttpStatus.OK);
    }

    @GetMapping(value = "/{idecran}")
    public ResponseEntity<EcranQueryDTO> getEcranByID(
            @PathVariable(value = "idecran") UUID idecran

    ) {
        return new ResponseEntity<>(ecranService.getEcran(idecran),
                HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<UUID> createAbsenceEcran(@RequestBody @Valid EcranQueryDTO ecranQueryDTO) {
        return new ResponseEntity(ecranService.createEcran(ecranQueryDTO), HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/{idecran}")
    public void deleteAbsenceEcran(
            @PathVariable(value = "idecran") UUID idecran){

        ecranService.delete(idecran);

    }
}
