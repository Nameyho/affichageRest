package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DTO.CoursEnseigneQueryDTO;
import com.affichageRest.affichageRest.model.CoursEnseigneID;

import java.util.List;

public interface CoursEnseigneService {

    List<CoursEnseigneQueryDTO> getAllCoursEnseignes();

    CoursEnseigneQueryDTO createCoursEnseigne(CoursEnseigneQueryDTO CoursEnseigneQueryDTO);

    CoursEnseigneQueryDTO getCoursEnseigne(CoursEnseigneID id);

    void updateCoursEnseigne(CoursEnseigneID id, CoursEnseigneQueryDTO CoursEnseigne);

    void delete(CoursEnseigneID id);

}
