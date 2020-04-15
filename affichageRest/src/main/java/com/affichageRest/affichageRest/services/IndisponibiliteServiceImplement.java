package com.affichageRest.affichageRest.services;



import com.affichageRest.affichageRest.DAO.IndisponibiliteRepository;
import com.affichageRest.affichageRest.model.Indisponibilite;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.UUID;

@Service(value="IndisponibiliteService")
public class IndisponibiliteServiceImplement implements IndisponibiliteService {

    @Resource
    private IndisponibiliteRepository indisponibiliteRepository;
    @Override
    public Collection<Indisponibilite> getAllCours() {
        return (Collection<Indisponibilite>) indisponibiliteRepository.findAll();
    }

    @Override
    public Indisponibilite getIndisponibilite(UUID id) {
        return this.indisponibiliteRepository.findById(id).get();
    }

    @Override
    public Indisponibilite save(Indisponibilite person) {
        return this.indisponibiliteRepository.save(person);
    }

    @Override
    public Indisponibilite updateIndisponibilite(UUID id, Indisponibilite indisponibilite) {
        //mettre à jour plus tard
        return this.indisponibiliteRepository.save(indisponibilite);
    }

    @Override
    public void delete(UUID id) {
        Indisponibilite cours = this.indisponibiliteRepository.findById(id).get();
        this.indisponibiliteRepository.delete(cours);
    }
}
