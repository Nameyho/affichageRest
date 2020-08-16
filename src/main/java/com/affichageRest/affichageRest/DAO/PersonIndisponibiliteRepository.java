package com.affichageRest.affichageRest.DAO;


import com.affichageRest.affichageRest.model.PersonIndisponibilite;
import com.affichageRest.affichageRest.model.PersonIndisponibilitePK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface PersonIndisponibiliteRepository extends CrudRepository<PersonIndisponibilite, PersonIndisponibilitePK> {

}
