package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DAO.CoursRepository;
import com.affichageRest.affichageRest.DTO.CoursQueryDTO;
import com.affichageRest.affichageRest.model.Cours;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service(value="coursService")
public class CoursServiceImplement implements CoursService {

    @Resource
    private CoursRepository coursRepository;


    @Override
    public List<CoursQueryDTO> getAllCours() {
        List<CoursQueryDTO> plist = new ArrayList<>();
        coursRepository.findAll().forEach(cours -> {
            plist.add(new CoursQueryDTO(cours.getId(),cours.getNom()));
        });
        return plist;
    }

    @Override
    public CoursQueryDTO getCours(UUID id) {
        if(coursRepository.findById(id).isPresent()){
            Cours  temp = coursRepository.findById(id).get();


            return new CoursQueryDTO(temp.getId(),temp.getNom());
        }
        else{
            return null;
        }
    }

    @Override
    public UUID createCours(CoursQueryDTO cours) {

        Cours newcours = new Cours();

        newcours.setId(UUID.nameUUIDFromBytes(cours.getName().getBytes()));
        newcours.setNom(cours.getName());


        return coursRepository.save(newcours).getId();
    }

    @Override
    public void updateCours(UUID id, CoursQueryDTO cours) {
        if (coursRepository.findById(id).isPresent()) {
            Cours coursexistant = coursRepository.findById(id).get();
            coursexistant.setNom(cours.getName());



        }

    }

    @Override
    public void delete(UUID id) {
        Cours role = this.coursRepository.findById(id).get();
        this.coursRepository.delete(role);
    }
}
