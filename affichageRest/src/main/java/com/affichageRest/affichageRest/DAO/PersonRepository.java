package com.affichageRest.affichageRest.DAO;

import com.affichageRest.affichageRest.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface PersonRepository extends CrudRepository<Person, UUID> {
}
