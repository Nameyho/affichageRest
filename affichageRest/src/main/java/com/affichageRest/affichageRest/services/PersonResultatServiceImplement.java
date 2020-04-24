package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.DAO.CoursRepository;
import com.affichageRest.affichageRest.DAO.PersonRepository;
import com.affichageRest.affichageRest.DAO.PersonResultatRepository;
import com.affichageRest.affichageRest.DTO.PersonResultatCreateDTO;
import com.affichageRest.affichageRest.DTO.PersonResultatGetDTO;
import com.affichageRest.affichageRest.DTO.PersonResultatUpdateDTO;
import com.affichageRest.affichageRest.model.PersonResultat;
import com.affichageRest.affichageRest.model.PersonResultatPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value="PersonResultat")
public class PersonResultatServiceImplement implements PersonResultatService {

    @Autowired
    private PersonResultatRepository personResultatRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CoursRepository coursRepository;

    @Override
    public List<PersonResultatGetDTO> getAllResultat() {

        List<PersonResultatGetDTO> plist = new ArrayList<>();
        personResultatRepository.findAll().forEach(resultat -> {
            plist.add(new PersonResultatGetDTO(resultat.getPersonResultatPK().idPerson,resultat.getPersonResultatPK().idCours,resultat.getAnnee(),resultat.getResultat(),resultat.isReussite()));
        });
        return plist;
    }

    @Override
    public PersonResultatGetDTO getPersonResultat(PersonResultatPK id) {

        if(personResultatRepository.findById(id).isPresent()){
            PersonResultat persontemp = personResultatRepository.findById(id).get();


            return new PersonResultatGetDTO(persontemp.getPersonResultatPK().idPerson,persontemp.getPersonResultatPK().idCours,persontemp.getAnnee(),persontemp.getResultat(),persontemp.isReussite());
        }
    else{
        return null;
    }}

    @Override
    public PersonResultat createResultat(PersonResultatCreateDTO resultatCreateDTO) {

        PersonResultat nouvResultat= new PersonResultat();

        PersonResultatPK personResultatPK = new PersonResultatPK();

        personResultatPK.setIdCours(resultatCreateDTO.getIdCours());
        personResultatPK.setIdPerson(resultatCreateDTO.getIdPerson());

        nouvResultat.setPersonResultatPK(personResultatPK);
        nouvResultat.setAnnee(resultatCreateDTO.getAnnee());
        nouvResultat.setResultat(resultatCreateDTO.getResultat());
        nouvResultat.setReussite(resultatCreateDTO.isReussite());

        return personResultatRepository.save(nouvResultat);
    }

    @Override
    public void updateResultat(PersonResultatPK id, PersonResultatUpdateDTO person) {

        if(personResultatRepository.findById(id).isPresent()) {
            PersonResultat resultatExistant = personResultatRepository.findById(id).get();

            resultatExistant.setReussite(person.isReussite());
            resultatExistant.setResultat(person.getResultat());
            resultatExistant.setAnnee(person.getAnnee());


            personResultatRepository.save(resultatExistant);

        }

    }

    @Override
    public void delete(PersonResultatPK id) {
        PersonResultat personne = this.personResultatRepository.findById(id).get();
        this.personResultatRepository.delete(personne);
    }
}
