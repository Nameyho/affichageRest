package com.affichageRest.affichageRest.DAO;

import com.affichageRest.affichageRest.model.EcranMessage;
import com.affichageRest.affichageRest.model.EcranMessageID;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface EcranMessageRepository extends CrudRepository<EcranMessage, EcranMessageID> {


    List<EcranMessage> getAllByEcranMessageID_IdEcran(UUID id);
}
