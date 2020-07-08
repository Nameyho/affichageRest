package com.affichageRest.affichageRest.DAO;

import com.affichageRest.affichageRest.model.EcranAbsence;
import com.affichageRest.affichageRest.model.EcranAbsenceID;
import org.springframework.data.repository.CrudRepository;

public interface EcranAbsenceRepository extends CrudRepository<EcranAbsence, EcranAbsenceID> {
}
