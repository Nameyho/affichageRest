package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.DTO.PersonCreateDTO;
import com.affichageRest.affichageRest.DTO.PersonGetDTO;
import com.affichageRest.affichageRest.DTO.PersonUpdateDTO;
import java.util.List;
import java.util.UUID;

public interface PersonService {

    List<PersonGetDTO> getAllPerson();
    public UUID createPerson(PersonCreateDTO personCreateDTO);
    PersonGetDTO getPerson(UUID id);

    void updatePerson(UUID id, PersonUpdateDTO personUpdateDTO);
    void delete(UUID id);

}
