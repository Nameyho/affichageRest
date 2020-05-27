package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DTO.PersonIndisponibiliteCreateDTO;
import com.affichageRest.affichageRest.DTO.PersonIndisponibiliteGetDTO;
import com.affichageRest.affichageRest.DTO.PersonIndisponibiliteUpdateDTO;
import com.affichageRest.affichageRest.DTO.PersonResultatGetDTO;
import com.affichageRest.affichageRest.model.PersonIndisponibilite;
import com.affichageRest.affichageRest.model.PersonIndisponibilitePK;

import java.util.List;

public interface PersonIndisponibiliteService {

    List<PersonIndisponibiliteGetDTO> getAllPersonIndisponibilite();

    PersonIndisponibilite createPersonIndisponibilite(PersonIndisponibiliteCreateDTO CoursEnseigneCreateDTO);

    PersonIndisponibiliteGetDTO getPersonIndisponibilite(PersonIndisponibilitePK id);

    void updatePersonIndisponibilite(PersonIndisponibilitePK id, PersonIndisponibiliteUpdateDTO personIndisponibiliteUpdateDTO);

    void delete(PersonIndisponibilitePK id);

}
