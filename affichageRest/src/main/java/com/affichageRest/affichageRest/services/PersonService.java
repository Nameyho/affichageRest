package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.DTO.PersonQueryDTO;


import java.util.List;
import java.util.UUID;

public interface PersonService  {

    List<PersonQueryDTO> getAllPerson();
    UUID createPerson(PersonQueryDTO personQueryDTO);
    PersonQueryDTO getPerson(UUID id);
    void updatePerson(UUID id, PersonQueryDTO personUpdateDTO);
    void delete(UUID id);

}
