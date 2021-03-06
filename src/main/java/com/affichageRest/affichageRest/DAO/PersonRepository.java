package com.affichageRest.affichageRest.DAO;

import com.affichageRest.affichageRest.model.Person;
import com.affichageRest.affichageRest.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface PersonRepository extends CrudRepository<Person, UUID> {

    List<Person> findAllByRoles(Role idRole);
    List<Person> findByNumerounique(int nume);
    List<Person> findByNom(String nom);

}
