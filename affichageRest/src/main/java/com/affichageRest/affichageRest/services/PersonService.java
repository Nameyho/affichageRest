package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.DTO.PersonCreateDTO;
import com.affichageRest.affichageRest.DTO.PersonUpdateDTO;
import com.affichageRest.affichageRest.model.Person;

import java.util.Collection;
import java.util.UUID;

public interface PersonService {

    Collection<Person> getAllPerson();
    public UUID createPerson(PersonCreateDTO personCreateDTO);
    Person getPerson(UUID id);

    void updatePerson(UUID id, PersonUpdateDTO personUpdateDTO);
    void delete(UUID id);

}
