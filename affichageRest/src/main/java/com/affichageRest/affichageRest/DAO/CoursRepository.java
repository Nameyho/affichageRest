package com.affichageRest.affichageRest.DAO;

import com.affichageRest.affichageRest.model.Cours;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CoursRepository extends CrudRepository<Cours, UUID> {
}
