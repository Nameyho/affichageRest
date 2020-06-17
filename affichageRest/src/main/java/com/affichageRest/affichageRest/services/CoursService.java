package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.DTO.CoursQueryDTO;

import java.util.List;
import java.util.UUID;

public interface CoursService {

    List<CoursQueryDTO> getAllCours();
    CoursQueryDTO getCours(UUID id);
    UUID createCours(CoursQueryDTO person);
    void updateCours(UUID id, CoursQueryDTO person);
    void delete(UUID id);

}
