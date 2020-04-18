package com.affichageRest.affichageRest.services;



import com.affichageRest.affichageRest.DAO.IndisponibiliteRepository;
import com.affichageRest.affichageRest.DTO.IndisponibiliteCreateDTO;
import com.affichageRest.affichageRest.DTO.IndisponibiliteGetDTO;
import com.affichageRest.affichageRest.DTO.IndisponibiliteUpdateDTO;
import com.affichageRest.affichageRest.model.Indisponibilite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service(value="IndisponibiliteService")
public class IndisponibiliteServiceImplement implements IndisponibiliteService {

    @Autowired
    private IndisponibiliteRepository indisponibiliteRepository;


    @Override
    public List<IndisponibiliteGetDTO> getAllCours() {
        List<IndisponibiliteGetDTO> plist = new ArrayList<>();
        indisponibiliteRepository.findAll().forEach(indisponibilite -> {
            plist.add(new IndisponibiliteGetDTO(indisponibilite.getIdinsponibilite(),indisponibilite.getType()));
        });
        return plist;
    }

    @Override
    public IndisponibiliteGetDTO getIndisponibilite(UUID id) {
        if(indisponibiliteRepository.findById(id).isPresent()){
            Indisponibilite temp = indisponibiliteRepository.findById(id).get();


            return new IndisponibiliteGetDTO(temp.getIdinsponibilite(),temp.getType());
        }
        else{
            return null;
        }
    }


    @Override
    public UUID createIndisponibilite(IndisponibiliteCreateDTO indispo) {

       Indisponibilite newIndispo = new Indisponibilite();

       newIndispo.setIdinsponibilite(indispo.getIdindisponibilite());
       newIndispo.setType(indispo.getType());

        return indisponibiliteRepository.save(newIndispo).getIdinsponibilite();
    }

    @Override
    public void updateIndisponibilite(UUID id, IndisponibiliteUpdateDTO indisponibilite) {
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
