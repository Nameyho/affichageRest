package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DTO.EcranResultatQueryDTO;
import com.affichageRest.affichageRest.model.EcranResultatID;

import java.util.List;
import java.util.UUID;

public interface EcranResultatService {

    List<EcranResultatQueryDTO> getAllEcranresultat();

    EcranResultatQueryDTO createEcranResultat(EcranResultatQueryDTO ecranResultatQueryDTO);

    EcranResultatQueryDTO getEcranResultat(EcranResultatID id);

    /* void updateEcranResultat(EcranResultatID id, EcranResultatQueryDTO ecranResultatQueryDTO);*/

    void delete(EcranResultatID id);

     List<EcranResultatQueryDTO> findbyidecran(UUID id);

}
