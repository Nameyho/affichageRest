package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DAO.CoursRepository;
import com.affichageRest.affichageRest.model.Cours;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.UUID;

@Service(value="CoursService")
public class CoursServiceImplement implements CoursService {

    @Resource
    private CoursRepository coursRepository;
    @Override
    public Collection<Cours> getAllCours() {
        return (Collection<Cours>) coursRepository.findAll();
    }

    @Override
    public Cours getCours(UUID id) {
        return this.coursRepository.findById(id).get();
    }

    @Override
    public Cours save(Cours person) {
        return this.coursRepository.save(person);
    }

    @Override
    public Cours updateCours(UUID id, Cours person) {
        //mettre à jour plus tard
        return this.coursRepository.save(person);
    }

    @Override
    public void delete(UUID id) {
        Cours cours = this.coursRepository.findById(id).get();
        this.coursRepository.delete(cours);
    }
}
