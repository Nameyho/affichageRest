package com.affichageRest.affichageRest.DAO;


import com.affichageRest.affichageRest.model.PersonIndisponibilite;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PersonIndisponibiliteRepository extends CrudRepository<PersonIndisponibilite, UUID> {
}
