package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DAO.CoursRepository;
import com.affichageRest.affichageRest.DAO.EcranRepository;
import com.affichageRest.affichageRest.DAO.EcranResultatRepository;
import com.affichageRest.affichageRest.DTO.EcranQueryDTO;
import com.affichageRest.affichageRest.DTO.EcranResultatQueryDTO;
import com.affichageRest.affichageRest.model.Ecran;
import com.affichageRest.affichageRest.model.EcranResultat;
import com.affichageRest.affichageRest.model.EcranResultatID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service(value = "EcranService")
public class EcranServiceImplement implements EcranService {


    @Autowired
    private EcranRepository ecranRepository;



    @Override
    public List<EcranQueryDTO> getAllEcran() {
        List<EcranQueryDTO> plist = new ArrayList<>();
        ecranRepository.findAll().forEach(ecran -> {
            plist.add(new EcranQueryDTO(
                    ecran.getIdEcran(),
                    ecran.getNomEcran()));
        });
        return plist;
    }

    @Override
    public EcranQueryDTO createEcran(EcranQueryDTO ecranQueryDTO) {

        Ecran ecran = new Ecran(ecranQueryDTO.getNomEcran());
        ecranRepository.save(ecran);

        return ecranQueryDTO;
    }

    @Override
    public EcranQueryDTO getEcran(UUID id) {
        if (ecranRepository.findById(id).isPresent()) {
            Ecran ecran = ecranRepository.findById(id).get();

            return new EcranQueryDTO(
                   ecran.getIdEcran(),
                    ecran.getNomEcran()

                    );
        } else {
            return null;
        }
    }



    @Override
    public void delete(UUID id) {
        this.ecranRepository.delete(ecranRepository.findById(id).get());
    }
}
