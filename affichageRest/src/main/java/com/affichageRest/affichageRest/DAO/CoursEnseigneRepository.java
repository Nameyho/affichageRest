package com.affichageRest.affichageRest.DAO;

import com.affichageRest.affichageRest.model.CoursEnseigne;
import com.affichageRest.affichageRest.model.CoursEnseigneID;
import org.springframework.data.repository.CrudRepository;

public interface CoursEnseigneRepository extends CrudRepository<CoursEnseigne, CoursEnseigneID> {
}
