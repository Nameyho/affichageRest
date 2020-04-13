package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.DTO.CoursCreateDTO;
import com.affichageRest.affichageRest.DTO.CoursGetDTO;
import com.affichageRest.affichageRest.DTO.CoursUpdateDTO;
import com.affichageRest.affichageRest.model.Cours;


import java.util.List;
import java.util.UUID;

public interface CoursService {

    List<CoursGetDTO> getAllCours();
    CoursGetDTO getCours(UUID id);
    UUID createCours(CoursCreateDTO person);
    void updateCours(UUID id, CoursUpdateDTO person);
    void delete(UUID id);

}
