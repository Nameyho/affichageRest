package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DAO.CoursRepository;
import com.affichageRest.affichageRest.DAO.IndisponibiliteRepository;
import com.affichageRest.affichageRest.DAO.PersonIndisponibiliteRepository;
import com.affichageRest.affichageRest.DAO.PersonRepository;
import com.affichageRest.affichageRest.DTO.PersonIndisponibiliteQueryDTO;
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
    private IndisponibiliteRepository indisponibiliteRepository;

    @Autowired
    private CoursRepository coursRepository;



    @Override
    public List<PersonIndisponibiliteQueryDTO> getAllPersonIndisponibilite () {
        List<PersonIndisponibiliteQueryDTO> plist = new ArrayList<>();


        personIndisponibiliteRepository.findAll().forEach(pIndisp -> {
            plist.add(new PersonIndisponibiliteQueryDTO(
                    pIndisp.getPersonIndisponibilitePK().getIdPerson(),
                    pIndisp.getPersonIndisponibilitePK().getIndispo_id(),
                    pIndisp.getPersonIndisponibilitePK().getIdSpecifique(),
                    pIndisp.getDateDebut(),pIndisp.getDateFin(),
                    personRepository.findById(pIndisp.getPersonIndisponibilitePK().getIdPerson()).get().getNom(),
            indisponibiliteRepository.findById(pIndisp.getPersonIndisponibilitePK().getIndispo_id()).get().getType(),

            personRepository.findById(pIndisp.getPersonIndisponibilitePK().getIdPerson()).get().getPrenom()));
        });
        return plist;
    }

    @Override
    public PersonIndisponibiliteQueryDTO getPersonIndisponibilite(PersonIndisponibilitePK id) {
        if(personIndisponibiliteRepository.findById(id).isPresent()){
            PersonIndisponibilite temp = personIndisponibiliteRepository.findById(id).get();
            return new PersonIndisponibiliteQueryDTO(temp.getPersonIndisponibilitePK().getIdPerson(),
                    temp.getPersonIndisponibilitePK().getIndispo_id(),
                    temp.getPersonIndisponibilitePK().getIdSpecifique(),
                    temp.getDateDebut(),temp.getDateFin(),personRepository.findById(temp.getPersonIndisponibilitePK().getIdPerson()).get().getNom(),
            indisponibiliteRepository.findById(temp.getPersonIndisponibilitePK().getIndispo_id()).get().getType(),
            personRepository.findById(temp.getPersonIndisponibilitePK().getIdPerson()).get().getPrenom());

        }
        else{
            return null;
        }
    }

    @Override
    public PersonIndisponibilite createPersonIndisponibilite(PersonIndisponibiliteQueryDTO temp) {


        PersonIndisponibilitePK tempID = new PersonIndisponibilitePK();


        tempID.setIdPerson(temp.getIdPerson());
        tempID.setIndispo_id(temp.getIndispo_id());

        PersonIndisponibilite newPersonIndisponibilites = new PersonIndisponibilite();
        newPersonIndisponibilites.setDateDebut(temp.getDateDebut());

        newPersonIndisponibilites.setDateFin(temp.getDateFin());

        newPersonIndisponibilites.setPersonIndisponibilitePK(tempID);

      return personIndisponibiliteRepository.save(newPersonIndisponibilites);
    }

    @Override
    public void updatePersonIndisponibilite(PersonIndisponibilitePK id, PersonIndisponibiliteQueryDTO temp) {


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
