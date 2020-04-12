package com.affichageRest.affichageRest.DAO;

import com.affichageRest.affichageRest.model.CoursEnseigne;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CoursEnseigneRepository extends CrudRepository<CoursEnseigne, UUID> {
}
