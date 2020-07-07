package com.affichageRest.affichageRest.DAO;

import com.affichageRest.affichageRest.model.Ecran;
import com.affichageRest.affichageRest.model.EcranAbsence;
import com.affichageRest.affichageRest.model.EcranAbsenceID;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EcranAbsenceRepository extends CrudRepository<EcranAbsence, EcranAbsenceID> {
}
