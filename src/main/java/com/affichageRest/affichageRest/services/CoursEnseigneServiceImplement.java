package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DAO.CoursEnseigneRepository;
import com.affichageRest.affichageRest.DAO.CoursRepository;
import com.affichageRest.affichageRest.DAO.PersonRepository;
import com.affichageRest.affichageRest.DTO.CoursEnseigneQueryDTO;
import com.affichageRest.affichageRest.model.CoursEnseigne;
import com.affichageRest.affichageRest.model.CoursEnseigneID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "CoursEnseignesService")
public class CoursEnseigneServiceImplement implements CoursEnseigneService {

    @Autowired
    private CoursEnseigneRepository coursEnseigneRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CoursRepository coursRepository;


    @Override
    public List<CoursEnseigneQueryDTO> getAllCoursEnseignes() {
        List<CoursEnseigneQueryDTO> plist = new ArrayList<>();
        coursEnseigneRepository.findAll().forEach(coursEnseigne -> {

            String nomCours = coursRepository.findById(coursEnseigne.getEnseigneID().getIdCours()).get().getNom();
            String nomPerson = personRepository.findById(coursEnseigne.getEnseigneID().getIdPerson()).get().getNom();
            plist.add(new
                    CoursEnseigneQueryDTO(
                    coursEnseigne.getEnseigneID().getIdPerson(),
                    coursEnseigne.getEnseigneID().getIdCours(),
                    coursEnseigne.getAnneeDebut(),
                    coursEnseigne.getAnneeFin(),
                    nomCours,
                    nomPerson));


        });
        return plist;
    }

    @Override
    public CoursEnseigneQueryDTO getCoursEnseigne(CoursEnseigneID id) {
        if (coursEnseigneRepository.findById(id).isPresent()) {
            CoursEnseigne coursEnseigne = coursEnseigneRepository.findById(id).get();
            String nomCours = coursRepository.findById(coursEnseigne.getEnseigneID().getIdCours()).get().getNom();
            String nomPerson = personRepository.findById(coursEnseigne.getEnseigneID().getIdPerson()).get().getNom();

            return new
                    CoursEnseigneQueryDTO(
                    coursEnseigne.getEnseigneID().getIdPerson(),
                    coursEnseigne.getEnseigneID().getIdCours(),
                    coursEnseigne.getAnneeDebut(),
                    coursEnseigne.getAnneeFin(),
                    nomCours,
                    nomPerson


            );

        } else {
            return null;
        }
    }

    @Override
    public CoursEnseigneQueryDTO createCoursEnseigne(CoursEnseigneQueryDTO coursEnseigne) {


        CoursEnseigneID coursEnseigneID = new CoursEnseigneID();

        coursEnseigneID.setIdCours(coursEnseigne.getIdCours());
        coursEnseigneID.setIdPerson(coursEnseigne.getIdPerson());

        CoursEnseigne newCoursEnseignes = new CoursEnseigne();

        newCoursEnseignes.setEnseigneID(coursEnseigneID);

        newCoursEnseignes.setAnneeDebut(coursEnseigne.getAnneeDebut());
        newCoursEnseignes.setAnneeFin(coursEnseigne.getAnneeFin());

        coursEnseigneRepository.save(newCoursEnseignes);
        return coursEnseigne;
    }

    @Override
    public void updateCoursEnseigne(CoursEnseigneID id, CoursEnseigneQueryDTO coursEnseigne) {

        CoursEnseigne newCoursEnseignes = new CoursEnseigne();
        newCoursEnseignes.setAnneeDebut(coursEnseigne.getAnneeDebut());
        newCoursEnseignes.setAnneeFin(coursEnseigne.getAnneeFin());
        newCoursEnseignes.setEnseigneID(id);

        coursEnseigneRepository.save(newCoursEnseignes);

    }


    @Override
    public void delete(CoursEnseigneID coursEnseigneID) {

        CoursEnseigne coursEnseigne = coursEnseigneRepository.findById(coursEnseigneID).get();


        this.coursEnseigneRepository.delete(coursEnseigne);
    }
}
