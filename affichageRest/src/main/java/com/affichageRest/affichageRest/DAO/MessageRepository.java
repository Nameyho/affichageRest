package com.affichageRest.affichageRest.DAO;

import com.affichageRest.affichageRest.model.Messages;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Messages,Long> {
}
