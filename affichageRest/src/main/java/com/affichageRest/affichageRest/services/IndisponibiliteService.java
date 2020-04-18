package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.DTO.IndisponibiliteCreateDTO;
import com.affichageRest.affichageRest.DTO.IndisponibiliteGetDTO;
import com.affichageRest.affichageRest.DTO.IndisponibiliteUpdateDTO;
import com.affichageRest.affichageRest.model.Indisponibilite;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface IndisponibiliteService {

    List<IndisponibiliteGetDTO> getAllCours();
    IndisponibiliteGetDTO getIndisponibilite(UUID id);
    UUID createIndisponibilite(IndisponibiliteCreateDTO person);
    void updateIndisponibilite(UUID id, IndisponibiliteUpdateDTO person);
    void delete(UUID id);

}
