package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.model.Cours;

import java.util.Collection;
import java.util.UUID;

public interface CoursService {

    Collection<Cours> getAllCours();
    Cours getCours(UUID id);
    Cours save(Cours person);
    Cours updateCours(UUID id, Cours person);
    void delete(UUID id);

}
