package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DTO.PersonResultatQueryDTO;
import com.affichageRest.affichageRest.model.PersonResultat;
import com.affichageRest.affichageRest.model.PersonResultatPK;

import java.util.List;
import java.util.UUID;

public interface PersonResultatService {

    List<PersonResultatQueryDTO> getAllResultat();

    PersonResultat createResultat(PersonResultatQueryDTO personResultatCreateDTO);

    PersonResultatQueryDTO getPersonResultat(PersonResultatPK id);

    void updateResultat(PersonResultatPK id, PersonResultatQueryDTO CoursEnseigne);

    void delete(PersonResultatPK id);

    List<PersonResultatQueryDTO> getResultatbyPerson(UUID id);


}
