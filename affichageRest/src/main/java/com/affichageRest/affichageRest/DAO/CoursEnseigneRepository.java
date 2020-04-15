package com.affichageRest.affichageRest.DAO;

import com.affichageRest.affichageRest.model.CoursEnseigne;
import com.affichageRest.affichageRest.model.CoursEnseigneID;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CoursEnseigneRepository extends CrudRepository<CoursEnseigne, CoursEnseigneID> {
}
