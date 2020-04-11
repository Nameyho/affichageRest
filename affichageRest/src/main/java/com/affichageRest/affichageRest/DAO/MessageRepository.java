package com.affichageRest.affichageRest.DAO;

import com.affichageRest.affichageRest.model.Messages;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MessageRepository extends CrudRepository<Messages, UUID> {
}
