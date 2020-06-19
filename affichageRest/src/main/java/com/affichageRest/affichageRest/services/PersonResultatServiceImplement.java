package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.DAO.CoursRepository;
import com.affichageRest.affichageRest.DAO.PersonRepository;
import com.affichageRest.affichageRest.DAO.PersonResultatRepository;
import com.affichageRest.affichageRest.DTO.PersonResultatQueryDTO;
import com.affichageRest.affichageRest.model.Cours;
import com.affichageRest.affichageRest.model.PersonResultat;
import com.affichageRest.affichageRest.model.PersonResultatPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service(value="PersonResultat")
public class PersonResultatServiceImplement implements PersonResultatService {

    @Autowired
    private PersonResultatRepository personResultatRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CoursRepository coursRepository;

    @Override
    public List<PersonResultatQueryDTO> getAllResultat() {

        List<PersonResultatQueryDTO> plist = new ArrayList<>();
        personResultatRepository.findAll().forEach(resultat -> {
            Cours idcours = coursRepository.findById(resultat.getPersonResultatPK().getIdCours()).get();
            plist.add(new PersonResultatQueryDTO(resultat.getPersonResultatPK().idPerson,idcours.getNom(),resultat.getPersonResultatPK().idCours,resultat.getAnnee(),resultat.getResultat(),resultat.isReussite()));
        });
        return plist;
    }

    @Override
    public List<PersonResultatQueryDTO> getResultatbyPerson(UUID id) {


        List<PersonResultatQueryDTO> plist = new ArrayList<>();
        personResultatRepository.findByPerson(id).forEach(resultat -> {
           Cours idcours = coursRepository.findById(resultat.getPersonResultatPK().getIdCours()).get();
            plist.add(new PersonResultatQueryDTO(resultat.getPersonResultatPK().idPerson,idcours.getNom(),resultat.getPersonResultatPK().idCours,resultat.getAnnee(),resultat.getResultat(),resultat.isReussite()));
        });
        return plist;
    }


    @Override
    public PersonResultatQueryDTO getPersonResultat(PersonResultatPK id) {

        if(personResultatRepository.findById(id).isPresent()){
            PersonResultat persontemp = personResultatRepository.findById(id).get();

            Cours idcours = coursRepository.findById(persontemp.getPersonResultatPK().getIdCours()).get();
            return new PersonResultatQueryDTO(persontemp.getPersonResultatPK().idPerson,idcours.getNom(),persontemp.getPersonResultatPK().idCours,persontemp.getAnnee(),persontemp.getResultat(),persontemp.isReussite());
        }
    else{
        return null;
    }}

    @Override
    public PersonResultat createResultat(PersonResultatQueryDTO resultatCreateDTO) {

        PersonResultat nouvResultat= new PersonResultat();

        PersonResultatPK personResultatPK = new PersonResultatPK();

        personResultatPK.setIdCours(resultatCreateDTO.getCours_id());
        personResultatPK.setIdPerson(resultatCreateDTO.getIdPerson());

        nouvResultat.setPersonResultatPK(personResultatPK);
        nouvResultat.setAnnee(resultatCreateDTO.getAnnee());
        nouvResultat.setResultat(resultatCreateDTO.getResultat());
        nouvResultat.setReussite(resultatCreateDTO.isReussite());
        nouvResultat.setNomCours(coursRepository.findById(resultatCreateDTO.getCours_id()).get().getNom());
        return personResultatRepository.save(nouvResultat);
    }

    @Override
    public void updateResultat(PersonResultatPK id, PersonResultatQueryDTO person) {

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
