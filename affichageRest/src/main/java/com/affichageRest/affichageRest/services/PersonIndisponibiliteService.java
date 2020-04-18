package com.affichageRest.affichageRest.services;



import com.affichageRest.affichageRest.DTO.*;
import com.affichageRest.affichageRest.model.PersonIndisponibilite;
import com.affichageRest.affichageRest.model.PersonIndisponibilitePK;


import java.util.List;
import java.util.UUID;

public interface PersonIndisponibiliteService {

    List<PersonIndisponibiliteGetDTO> getAllPersonIndisponibilite();

    void createPersonIndisponibilite(PersonIndisponibiliteCreateDTO CoursEnseigneCreateDTO);

    PersonIndisponibiliteGetDTO getPersonIndisponibilite(PersonIndisponibilitePK id);

    void updatePersonIndisponibilite(PersonIndisponibilitePK id, PersonIndisponibiliteUpdateDTO personIndisponibiliteUpdateDTO);

    void delete(PersonResultatGetDTO id);

}
