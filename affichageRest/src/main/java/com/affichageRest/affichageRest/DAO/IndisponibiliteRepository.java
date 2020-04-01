package com.affichageRest.affichageRest.DAO;

import com.affichageRest.affichageRest.model.Indisponibilite;
import com.affichageRest.affichageRest.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface IndisponibiliteRepository extends CrudRepository<Indisponibilite,Long> {
}
