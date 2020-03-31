package com.affichageRest.affichageRest.DAO;

import com.affichageRest.affichageRest.model.Cours;
import org.springframework.data.repository.CrudRepository;

public interface CoursRepository extends CrudRepository<Cours,Long> {
}
