package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.model.Cours;

import java.util.Collection;

public interface CoursService {

    Collection<Cours> getAllCours();
    Cours getCours(Long id);
    Cours save(Cours person);
    Cours updatePerson(Long id, Cours person);
    void delete(Long id);

}
