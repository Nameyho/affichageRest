package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DAO.CoursEnseigneRepository;
import com.affichageRest.affichageRest.DAO.CoursRepository;
import com.affichageRest.affichageRest.DAO.PersonRepository;
import com.affichageRest.affichageRest.DTO.CoursEnseigneCreateDTO;
import com.affichageRest.affichageRest.DTO.CoursEnseigneGetDTO;
import com.affichageRest.affichageRest.DTO.CoursEnseigneUpdateDTO;
import com.affichageRest.affichageRest.model.CoursEnseigne;
import com.affichageRest.affichageRest.model.CoursEnseigneID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service(value="CoursEnseignesService")
public class CoursEnseigneServiceImplement implements CoursEnseigneService {

    @Autowired
    private CoursEnseigneRepository coursEnseigneRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CoursRepository coursRepository;



    @Override
    public List<CoursEnseigneGetDTO> getAllCoursEnseignes() {
        List<CoursEnseigneGetDTO> plist = new ArrayList<>();
        coursEnseigneRepository.findAll().forEach(CoursEnseigne -> {
            plist.add(new CoursEnseigneGetDTO(CoursEnseigne.getEnseigneID().getIdPerson(),CoursEnseigne.getEnseigneID().getIdCours(),CoursEnseigne.getAnnee()));
        });
        return plist;
    }

    @Override
    public CoursEnseigneGetDTO getCoursEnseigne(CoursEnseigneID id) {
        if(coursEnseigneRepository.findById(id).isPresent()){
            CoursEnseigne  temp = coursEnseigneRepository.findById(id).get();


            return new CoursEnseigneGetDTO(temp.getEnseigneID().getIdPerson(),temp.getEnseigneID().getIdCours(),temp.getAnnee());
        }
        else{
            return null;
        }
    }

    @Override
    public CoursEnseigneCreateDTO createCoursEnseigne(CoursEnseigneCreateDTO coursEnseigne) {


        CoursEnseigneID coursEnseigneID = new CoursEnseigneID();

        coursEnseigneID.setIdCours(coursEnseigne.getIdCours());
        coursEnseigneID.setIdPerson(coursEnseigne.getIdPerson());

        CoursEnseigne newCoursEnseignes = new CoursEnseigne();
        newCoursEnseignes.setAnnee(coursEnseigne.getAnnee());

        newCoursEnseignes.setEnseigneID(coursEnseigneID);

       coursEnseigneRepository.save(newCoursEnseignes);
        return coursEnseigne;
    }

    @Override
    public void updateCoursEnseigne(CoursEnseigneID id, CoursEnseigneUpdateDTO coursEnseigne) {




        CoursEnseigne newCoursEnseignes = new CoursEnseigne();
        newCoursEnseignes.setAnnee(coursEnseigne.getAnnee());



        newCoursEnseignes.setEnseigneID(id);

        coursEnseigneRepository.save(newCoursEnseignes);

        }


    @Override
    public void delete(CoursEnseigneID coursEnseigneID) {

     CoursEnseigne coursEnseigne = coursEnseigneRepository.findById(coursEnseigneID).get();


        this.coursEnseigneRepository.delete(coursEnseigne);
    }
}
