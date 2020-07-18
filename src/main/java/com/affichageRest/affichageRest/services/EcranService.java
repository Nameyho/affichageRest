package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.DTO.EcranQueryDTO;
import com.affichageRest.affichageRest.DTO.EcranResultatQueryDTO;
import com.affichageRest.affichageRest.model.EcranResultatID;

import java.util.List;
import java.util.UUID;

public interface EcranService {
    List<EcranQueryDTO> getAllEcran();

    EcranQueryDTO createEcran(EcranQueryDTO ecranQueryDTO);

    EcranQueryDTO getEcran(UUID id);

    /* void updateEcran(EcranResultatID id, EcranResultatQueryDTO ecranResultatQueryDTO);*/

    void delete(UUID id);

}
