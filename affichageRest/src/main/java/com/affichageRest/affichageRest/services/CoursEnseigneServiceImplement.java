package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DAO.CoursEnseigneRepository;
import com.affichageRest.affichageRest.DAO.CoursRepository;
import com.affichageRest.affichageRest.DAO.PersonRepository;
import com.affichageRest.affichageRest.DTO.CoursEnseigneCreateDTO;
import com.affichageRest.affichageRest.DTO.CoursEnseigneGetDTO;
import com.affichageRest.affichageRest.DTO.CoursEnseigneUpdateDTO;
import com.affichageRest.affichageRest.model.Cours;
import com.affichageRest.affichageRest.model.CoursEnseigne;
import com.affichageRest.affichageRest.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service(value="CoursEnseignesService")
public class CoursEnseigneServiceImplement implements CoursEnseigneService {

    @Autowired
    private CoursEnseigneRepository CoursEnseigneRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CoursRepository coursRepository;



    @Override
    public List<CoursEnseigneGetDTO> getAllCoursEnseignes() {
        List<CoursEnseigneGetDTO> plist = new ArrayList<>();
        CoursEnseigneRepository.findAll().forEach(CoursEnseigne -> {
            plist.add(new CoursEnseigneGetDTO(CoursEnseigne.getPerson().getIdPerson(),CoursEnseigne.getCours().getId(),CoursEnseigne.getAnnee()));
        });
        return plist;
    }

    @Override
    public CoursEnseigneGetDTO getCoursEnseigne(UUID id) {
        if(CoursEnseigneRepository.findById(id).isPresent()){
            CoursEnseigne  temp = CoursEnseigneRepository.findById(id).get();


            return new CoursEnseigneGetDTO(temp.getPerson().getIdPerson(),temp.getCours().getId(),temp.getAnnee());
        }
        else{
            return null;
        }
    }

    @Override
    public void createCoursEnseigne(CoursEnseigneCreateDTO coursEnseigne) {

        CoursEnseigne newCoursEnseignes = new CoursEnseigne();
        newCoursEnseignes.setAnnee(coursEnseigne.getAnnee());

        Person person = personRepository.findById(coursEnseigne.getIdPerson()).get();

        newCoursEnseignes.setPerson(person);

        Cours cours = coursRepository.findById(coursEnseigne.getIdCours()).get();

        newCoursEnseignes.setCours(cours);

       CoursEnseigneRepository.save(newCoursEnseignes);
    }

    @Override
    public void updateCoursEnseigne(UUID id, CoursEnseigneUpdateDTO coursEnseigne) {


        CoursEnseigne newCoursEnseignes = new CoursEnseigne();
        newCoursEnseignes.setAnnee(coursEnseigne.getAnnee());

        Person person = personRepository.findById(coursEnseigne.getIdPerson()).get();

        newCoursEnseignes.setPerson(person);

        Cours cours = coursRepository.findById(coursEnseigne.getIdCours()).get();

        newCoursEnseignes.setCours(cours);

        CoursEnseigneRepository.save(newCoursEnseignes);

        }


    @Override
    public void delete(CoursEnseigneGetDTO coursEnseigneGetDTO) {

        CoursEnseigne coursEnseigne = new CoursEnseigne();

        coursEnseigne.setAnnee(coursEnseigneGetDTO.getAnnee());
        coursEnseigne.setCours(coursEnseigne.getCours());
        coursEnseigne.setPerson(coursEnseigne.getPerson());

        this.CoursEnseigneRepository.delete(coursEnseigne);
    }
}
