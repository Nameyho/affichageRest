package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DAO.CoursEnseigneRepository;
import com.affichageRest.affichageRest.DAO.CoursRepository;
import com.affichageRest.affichageRest.DAO.PersonRepository;
import com.affichageRest.affichageRest.DTO.CoursEnseigneCreateDTO;
import com.affichageRest.affichageRest.DTO.CoursEnseigneGetDTO;
import com.affichageRest.affichageRest.DTO.CoursEnseigneUpdateDTO;
import com.affichageRest.affichageRest.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.awt.desktop.SystemSleepEvent;
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
            plist.add(new CoursEnseigneGetDTO(CoursEnseigne.getEnseigneID().getIdPerson(),CoursEnseigne.getEnseigneID().getIdCours(),CoursEnseigne.getAnnee()));
        });
        return plist;
    }

    @Override
    public CoursEnseigneGetDTO getCoursEnseigne(CoursEnseigneID id) {
        if(CoursEnseigneRepository.findById(id).isPresent()){
            CoursEnseigne  temp = CoursEnseigneRepository.findById(id).get();


            return new CoursEnseigneGetDTO(temp.getEnseigneID().getIdPerson(),temp.getEnseigneID().getIdCours(),temp.getAnnee());
        }
        else{
            return null;
        }
    }

    @Override
    public void createCoursEnseigne(CoursEnseigneCreateDTO coursEnseigne) {


        CoursEnseigneID coursEnseigneID = new CoursEnseigneID();

        coursEnseigneID.setIdCours(coursEnseigne.getIdCours());
        coursEnseigneID.setIdPerson(coursEnseigne.getIdPerson());

        CoursEnseigne newCoursEnseignes = new CoursEnseigne();
        newCoursEnseignes.setAnnee(coursEnseigne.getAnnee());

        newCoursEnseignes.setEnseigneID(coursEnseigneID);

       CoursEnseigneRepository.save(newCoursEnseignes);
    }

    @Override
    public void updateCoursEnseigne(UUID id, CoursEnseigneUpdateDTO coursEnseigne) {


        CoursEnseigneID coursEnseigneID = new CoursEnseigneID();

        CoursEnseigne newCoursEnseignes = new CoursEnseigne();
        newCoursEnseignes.setAnnee(coursEnseigne.getAnnee());

        coursEnseigneID.setIdCours(coursEnseigne.getIdCours());
        coursEnseigneID.setIdPerson(coursEnseigne.getIdPerson());

        newCoursEnseignes.setEnseigneID(coursEnseigneID);

        CoursEnseigneRepository.save(newCoursEnseignes);

        }


    @Override
    public void delete(CoursEnseigneGetDTO coursEnseigneGetDTO) {

        CoursEnseigne coursEnseigne = new CoursEnseigne();

        coursEnseigne.setAnnee(coursEnseigneGetDTO.getAnnee());


        this.CoursEnseigneRepository.delete(coursEnseigne);
    }
}
