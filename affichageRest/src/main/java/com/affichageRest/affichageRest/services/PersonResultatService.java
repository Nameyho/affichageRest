package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DTO.PersonResultatCreateDTO;
import com.affichageRest.affichageRest.DTO.PersonResultatGetDTO;
import com.affichageRest.affichageRest.DTO.PersonResultatUpdateDTO;
import com.affichageRest.affichageRest.model.PersonResultat;
import com.affichageRest.affichageRest.model.PersonResultatPK;

import java.util.List;
import java.util.UUID;

public interface PersonResultatService {

    List<PersonResultatGetDTO> getAllResultat();

    PersonResultat createResultat(PersonResultatCreateDTO personResultatCreateDTO);

    PersonResultatGetDTO getPersonResultat(PersonResultatPK id);

    void updateResultat(PersonResultatPK id, PersonResultatUpdateDTO CoursEnseigne);

    void delete(PersonResultatPK id);

    List<PersonResultatGetDTO> getResultatbyPerson(UUID id);


}
