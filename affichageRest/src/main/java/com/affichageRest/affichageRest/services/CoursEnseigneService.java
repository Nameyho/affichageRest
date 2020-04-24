package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DTO.CoursEnseigneCreateDTO;
import com.affichageRest.affichageRest.DTO.CoursEnseigneGetDTO;
import com.affichageRest.affichageRest.DTO.CoursEnseigneUpdateDTO;
import com.affichageRest.affichageRest.model.CoursEnseigneID;

import java.util.List;
import java.util.UUID;

public interface CoursEnseigneService {

    List<CoursEnseigneGetDTO> getAllCoursEnseignes();

    void createCoursEnseigne(CoursEnseigneCreateDTO CoursEnseigneCreateDTO);

    CoursEnseigneGetDTO getCoursEnseigne(CoursEnseigneID id);

    void updateCoursEnseigne(UUID id, CoursEnseigneUpdateDTO CoursEnseigne);

    void delete(CoursEnseigneGetDTO id);

}
