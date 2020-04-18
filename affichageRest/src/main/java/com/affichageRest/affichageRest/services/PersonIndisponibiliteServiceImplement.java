package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DAO.IndisponibiliteRepository;
import com.affichageRest.affichageRest.DAO.PersonIndisponibiliteRepository;
import com.affichageRest.affichageRest.DAO.PersonRepository;
import com.affichageRest.affichageRest.DTO.*;
import com.affichageRest.affichageRest.model.PersonIndisponibilite;
import com.affichageRest.affichageRest.model.PersonIndisponibilitePK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service(value="PersonIndisponibiliteService")
public class PersonIndisponibiliteServiceImplement implements PersonIndisponibiliteService {

    @Autowired
    private PersonIndisponibiliteRepository personIndisponibiliteRepository ;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private IndisponibiliteRepository coursRepository;



    @Override
    public List<PersonIndisponibiliteGetDTO> getAllPersonIndisponibilite () {
        List<PersonIndisponibiliteGetDTO> plist = new ArrayList<>();
        personIndisponibiliteRepository.findAll().forEach(pIndisp -> {
            plist.add(new PersonIndisponibiliteGetDTO(pIndisp.getPersonIndisponibilitePK().getIdPerson(),pIndisp.getPersonIndisponibilitePK().getIdCours(),pIndisp.getDateDebut(),pIndisp.getDateFin()));
        });
        return plist;
    }

    @Override
    public PersonIndisponibiliteGetDTO getPersonIndisponibilite(PersonIndisponibilitePK id) {
        if(personIndisponibiliteRepository.findById(id).isPresent()){
            PersonIndisponibilite temp = personIndisponibiliteRepository.findById(id).get();


            return new PersonIndisponibiliteGetDTO(temp.getPersonIndisponibilitePK().getIdPerson(),temp.getPersonIndisponibilitePK().getIdCours(),temp.getDateDebut(),temp.getDateFin());
        }
        else{
            return null;
        }
    }

    @Override
    public void createPersonIndisponibilite(PersonIndisponibiliteCreateDTO temp) {


        PersonIndisponibilitePK tempID = new PersonIndisponibilitePK();

      tempID.setIdCours(temp.getIdCours());
        tempID.setIdPerson(temp.getIdPerson());

        PersonIndisponibilite newPersonIndisponibilites = new PersonIndisponibilite();
        newPersonIndisponibilites.setDateDebut(temp.getDateDebut());

        newPersonIndisponibilites.setDateFin(temp.getDateFin());

        newPersonIndisponibilites.setPersonIndisponibilitePK(tempID);

       personIndisponibiliteRepository.save(newPersonIndisponibilites);
    }

    @Override
    public void updatePersonIndisponibilite(PersonIndisponibilitePK id, PersonIndisponibiliteUpdateDTO temp) {


      if(personIndisponibiliteRepository.findById(id).isPresent()){
          PersonIndisponibilite personIndisponibilite = personIndisponibiliteRepository.findById(id).get();
          personIndisponibilite.setDateDebut(temp.getDateDebut());
          personIndisponibilite.setDateFin(temp.getDateFin());
      }

        }

    @Override
    public void delete(PersonResultatGetDTO personIndisponibiliteGetDTO) {

        PersonIndisponibilite temp = new PersonIndisponibilite();




        this.personIndisponibiliteRepository.delete(temp);
    }
}
