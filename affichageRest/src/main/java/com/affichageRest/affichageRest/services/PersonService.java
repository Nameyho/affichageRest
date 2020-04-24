package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.DTO.PersonCreateDTO;
import com.affichageRest.affichageRest.DTO.PersonGetDTO;
import com.affichageRest.affichageRest.DTO.PersonUpdateDTO;
import com.affichageRest.affichageRest.model.Person;
import org.springframework.security.core.userdetails.User;

import java.util.List;
import java.util.UUID;

public interface PersonService  {

    List<PersonGetDTO> getAllPerson();
    UUID createPerson(PersonCreateDTO personCreateDTO);
    PersonGetDTO getPerson(UUID id);
    void updatePerson(UUID id, PersonUpdateDTO personUpdateDTO);
    void delete(UUID id);

}
