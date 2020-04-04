package com.affichageRest.affichageRest.DAO;

import com.affichageRest.affichageRest.model.Person;
import com.affichageRest.affichageRest.model.PersonResultat;
import org.springframework.data.repository.CrudRepository;

public interface PersonResultatRepository extends CrudRepository<PersonResultat,Long> {
}
