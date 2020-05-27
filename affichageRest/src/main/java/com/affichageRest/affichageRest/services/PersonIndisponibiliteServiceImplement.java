package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DAO.IndisponibiliteRepository;
import com.affichageRest.affichageRest.DAO.PersonIndisponibiliteRepository;
import com.affichageRest.affichageRest.DAO.PersonRepository;
import com.affichageRest.affichageRest.DTO.PersonIndisponibiliteCreateDTO;
import com.affichageRest.affichageRest.DTO.PersonIndisponibiliteGetDTO;
import com.affichageRest.affichageRest.DTO.PersonIndisponibiliteUpdateDTO;
import com.affichageRest.affichageRest.model.PersonIndisponibilite;
import com.affichageRest.affichageRest.model.PersonIndisponibilitePK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

            System.out.println(pIndisp.getPersonIndisponibilitePK().getIndispo_id());
            plist.add(new PersonIndisponibiliteGetDTO(pIndisp.getPersonIndisponibilitePK().getIdPerson(),pIndisp.getPersonIndisponibilitePK().getIndispo_id(),pIndisp.getPersonIndisponibilitePK().getIdCours(),pIndisp.getDateDebut(),pIndisp.getDateFin()));
        });
        return plist;
    }

    @Override
    public PersonIndisponibiliteGetDTO getPersonIndisponibilite(PersonIndisponibilitePK id) {
        if(personIndisponibiliteRepository.findById(id).isPresent()){
            PersonIndisponibilite temp = personIndisponibiliteRepository.findById(id).get();


            return new PersonIndisponibiliteGetDTO(temp.getPersonIndisponibilitePK().getIdPerson(),temp.getPersonIndisponibilitePK().getIdCours(),temp.getPersonIndisponibilitePK().getIndispo_id(),temp.getDateDebut(),temp.getDateFin());
        }
        else{
            return null;
        }
    }

    @Override
    public PersonIndisponibilite createPersonIndisponibilite(PersonIndisponibiliteCreateDTO temp) {


        PersonIndisponibilitePK tempID = new PersonIndisponibilitePK();

        tempID.setIdCours(temp.getIdCours());
        tempID.setIdPerson(temp.getIdPerson());
        tempID.setIndispo_id(temp.getIndispo_id());

        PersonIndisponibilite newPersonIndisponibilites = new PersonIndisponibilite();
        newPersonIndisponibilites.setDateDebut(temp.getDateDebut());

        newPersonIndisponibilites.setDateFin(temp.getDateFin());

        newPersonIndisponibilites.setPersonIndisponibilitePK(tempID);

      return personIndisponibiliteRepository.save(newPersonIndisponibilites);
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
    public void delete(PersonIndisponibilitePK id) {



        PersonIndisponibilite personne = this.personIndisponibiliteRepository.findById(id).get();
        this.personIndisponibiliteRepository.delete(personne);



    }
}
