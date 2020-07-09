package com.affichageRest.affichageRest.DAO;

import com.affichageRest.affichageRest.model.EcranMessage;
import com.affichageRest.affichageRest.model.EcranMessageID;
import org.springframework.data.repository.CrudRepository;

public interface EcranMessageRepository extends CrudRepository<EcranMessage, EcranMessageID> {


}
