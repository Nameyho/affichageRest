package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.DTO.PersonQueryDTO;
import com.affichageRest.affichageRest.model.Person;
import com.affichageRest.affichageRest.model.Role;

import java.util.List;
import java.util.UUID;

public interface PersonService {

    List<PersonQueryDTO> getAllPerson();

    UUID createPerson(PersonQueryDTO personQueryDTO);

    PersonQueryDTO getPerson(UUID id);

    void updatePerson(UUID id, PersonQueryDTO personUpdateDTO);

    void delete(UUID id);

    List<PersonQueryDTO> findAllByRoles(Role idRole);

    List<PersonQueryDTO> findByNumerounique(int nume);

}
