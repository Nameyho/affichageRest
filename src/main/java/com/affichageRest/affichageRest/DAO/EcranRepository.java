package com.affichageRest.affichageRest.DAO;

import com.affichageRest.affichageRest.model.Ecran;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EcranRepository extends CrudRepository<Ecran, UUID> {
}
