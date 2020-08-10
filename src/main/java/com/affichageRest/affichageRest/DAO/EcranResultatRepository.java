package com.affichageRest.affichageRest.DAO;

import com.affichageRest.affichageRest.model.EcranResultat;
import com.affichageRest.affichageRest.model.EcranResultatID;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface EcranResultatRepository extends CrudRepository<EcranResultat, EcranResultatID> {

    List<EcranResultat> findAllByEcranResultatID_IdEcran(UUID idecran);

}
