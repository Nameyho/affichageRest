package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.DTO.IndisponibiliteQueryDTO;

import java.util.List;
import java.util.UUID;

public interface IndisponibiliteService {

    List<IndisponibiliteQueryDTO> getAllIndispo();
    IndisponibiliteQueryDTO getIndisponibilite(UUID id);
    UUID createIndisponibilite(IndisponibiliteQueryDTO person);
    void updateIndisponibilite(UUID id, IndisponibiliteQueryDTO person);
    void delete(UUID id);

}
