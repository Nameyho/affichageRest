package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.model.Indisponibilite;

import java.util.Collection;
import java.util.UUID;

public interface IndisponibiliteService {

    Collection<Indisponibilite> getAllCours();
    Indisponibilite getIndisponibilite(UUID id);
    Indisponibilite save(Indisponibilite person);
    Indisponibilite updateIndisponibilite(UUID id, Indisponibilite person);
    void delete(UUID id);

}
