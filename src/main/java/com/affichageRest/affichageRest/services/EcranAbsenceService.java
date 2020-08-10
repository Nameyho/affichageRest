package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DTO.EcranAbsenceQueryDTO;
import com.affichageRest.affichageRest.model.EcranAbsence;
import com.affichageRest.affichageRest.model.EcranAbsenceID;

import java.util.List;
import java.util.UUID;

public interface EcranAbsenceService {

    List<EcranAbsenceQueryDTO> getAllEcran();

    EcranAbsenceQueryDTO createEcranAbsence(EcranAbsenceQueryDTO ecranAbsenceQueryDTO);

    EcranAbsenceQueryDTO getEcranAbsence(EcranAbsenceID id);

    void updateEcranAbsence(EcranAbsenceID id, EcranAbsenceQueryDTO CoursEnseigne);

    void delete(EcranAbsenceID id);

    List<EcranAbsenceQueryDTO> findAllByEcranAbsenceID_IdEcran(UUID uuid);

}
