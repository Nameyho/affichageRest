package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DTO.PersonIndisponibiliteQueryDTO;
import com.affichageRest.affichageRest.model.PersonIndisponibilite;
import com.affichageRest.affichageRest.model.PersonIndisponibilitePK;

import java.util.List;

public interface PersonIndisponibiliteService {

    List<PersonIndisponibiliteQueryDTO> getAllPersonIndisponibilite();

    PersonIndisponibilite createPersonIndisponibilite(PersonIndisponibiliteQueryDTO CoursEnseigneCreateDTO);

    PersonIndisponibiliteQueryDTO getPersonIndisponibilite(PersonIndisponibilitePK id);

    void updatePersonIndisponibilite(PersonIndisponibilitePK id, PersonIndisponibiliteQueryDTO personIndisponibiliteUpdateDTO);

    void delete(PersonIndisponibilitePK id);

}
