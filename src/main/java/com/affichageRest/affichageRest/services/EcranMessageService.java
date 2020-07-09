package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DTO.EcranMessageQueryDTO;
import com.affichageRest.affichageRest.DTO.EcranResultatQueryDTO;
import com.affichageRest.affichageRest.model.EcranMessageID;
import com.affichageRest.affichageRest.model.EcranResultatID;

import java.util.List;

public interface EcranMessageService {

    List<EcranMessageQueryDTO> getAllEcranMessage();

    EcranMessageQueryDTO createEcranMessage(EcranMessageQueryDTO ecranMessageQueryDTO);

    EcranMessageQueryDTO getEcranMessage(EcranMessageID id);

    /* void updateEcranResultat(EcranResultatID id, EcranResultatQueryDTO ecranResultatQueryDTO);*/

    void delete(EcranMessageID id);

}
