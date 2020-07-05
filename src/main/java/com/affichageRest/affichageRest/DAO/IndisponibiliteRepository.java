package com.affichageRest.affichageRest.DAO;

import com.affichageRest.affichageRest.model.Indisponibilite;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IndisponibiliteRepository extends CrudRepository<Indisponibilite, UUID> {
}
