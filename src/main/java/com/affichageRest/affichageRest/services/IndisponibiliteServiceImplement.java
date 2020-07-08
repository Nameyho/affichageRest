package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DAO.IndisponibiliteRepository;
import com.affichageRest.affichageRest.DTO.IndisponibiliteQueryDTO;
import com.affichageRest.affichageRest.model.Indisponibilite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service(value = "IndisponibiliteService")
public class IndisponibiliteServiceImplement implements IndisponibiliteService {

    @Autowired
    private IndisponibiliteRepository indisponibiliteRepository;


    @Override
    public List<IndisponibiliteQueryDTO> getAllIndispo() {
        List<IndisponibiliteQueryDTO> plist = new ArrayList<>();
        indisponibiliteRepository.findAll().forEach(indisponibilite -> {
            plist.add(new IndisponibiliteQueryDTO(indisponibilite.getIdinsponibilite(), indisponibilite.getType()));
        });
        return plist;
    }

    @Override
    public IndisponibiliteQueryDTO getIndisponibilite(UUID id) {
        if (indisponibiliteRepository.findById(id).isPresent()) {
            Indisponibilite temp = indisponibiliteRepository.findById(id).get();


            return new IndisponibiliteQueryDTO(temp.getIdinsponibilite(), temp.getType());
        } else {
            return null;
        }
    }


    @Override
    public UUID createIndisponibilite(IndisponibiliteQueryDTO indispo) {

        Indisponibilite newIndispo = new Indisponibilite();

        newIndispo.setIdinsponibilite(indispo.getIdindisponibilite());
        newIndispo.setType(indispo.getType());
        newIndispo.setIdinsponibilite(UUID.nameUUIDFromBytes(indispo.getType().getBytes()));

        return indisponibiliteRepository.save(newIndispo).getIdinsponibilite();
    }

    @Override
    public void updateIndisponibilite(UUID id, IndisponibiliteQueryDTO indisponibilite) {
        if (indisponibiliteRepository.findById(id).isPresent()) {
            Indisponibilite coursexistant = indisponibiliteRepository.findById(id).get();


            coursexistant.setType(indisponibilite.getType());


        }
    }

    @Override
    public void delete(UUID id) {
        Indisponibilite cours = this.indisponibiliteRepository.findById(id).get();
        this.indisponibiliteRepository.delete(cours);
    }
}
