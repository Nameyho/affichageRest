package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.model.Indisponibilite;

import java.util.Collection;

public interface IndisponibiliteService {

    Collection<Indisponibilite> getAllCours();
    Indisponibilite getIndisponibilite(Long id);
    Indisponibilite save(Indisponibilite person);
    Indisponibilite updateIndisponibilite(Long id, Indisponibilite person);
    void delete(Long id);

}
