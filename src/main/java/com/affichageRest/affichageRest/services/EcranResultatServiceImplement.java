package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DAO.CoursRepository;
import com.affichageRest.affichageRest.DAO.EcranRepository;
import com.affichageRest.affichageRest.DAO.EcranResultatRepository;
import com.affichageRest.affichageRest.DTO.EcranResultatQueryDTO;
import com.affichageRest.affichageRest.model.EcranResultat;
import com.affichageRest.affichageRest.model.EcranResultatID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service(value = "EcranResultatService")
public class EcranResultatServiceImplement implements EcranResultatService {


    @Autowired
    private EcranResultatRepository ecranResultatRepository;

    @Autowired
    private CoursRepository coursRepository;

    @Autowired
    private EcranRepository ecranRepository;

    @Override
    public List<EcranResultatQueryDTO> getAllEcranresultat() {
        List<EcranResultatQueryDTO> plist = new ArrayList<>();
        ecranResultatRepository.findAll().forEach(ecranResultat -> {
            plist.add(new EcranResultatQueryDTO(
                    ecranResultat.getEcranResultatID().getIdEcran(),
                    ecranRepository.findById(ecranResultat.getEcranResultatID().getIdEcran()).get().getNomEcran(),
                    ecranResultat.getEcranResultatID().getIdCours(),
                    coursRepository.findById(ecranResultat.getEcranResultatID().getIdCours()).get().getNom()));
        });
        return plist;
    }

    @Override
    public EcranResultatQueryDTO createEcranResultat(EcranResultatQueryDTO ecranResultatQueryDTO) {


        EcranResultatID ecranResultatID = new EcranResultatID(
                ecranResultatQueryDTO.getIdEcran(),
                ecranResultatQueryDTO.getIdCours()
        );

        EcranResultat ecranResultat = new EcranResultat(ecranResultatID);

        ecranResultatRepository.save(ecranResultat);

        return ecranResultatQueryDTO;
    }

    @Override
    public EcranResultatQueryDTO getEcranResultat(EcranResultatID id) {
        if (ecranResultatRepository.findById(id).isPresent()) {
            EcranResultat ecranResultat = ecranResultatRepository.findById(id).get();

            return new EcranResultatQueryDTO(
                    ecranResultat.getEcranResultatID().getIdEcran(),
                    ecranRepository.findById(ecranResultat.getEcranResultatID().getIdEcran()).get().getNomEcran(),
                    ecranResultat.getEcranResultatID().getIdCours(),
                    coursRepository.findById(ecranResultat.getEcranResultatID().getIdCours()).get().getNom());
        } else {
            return null;
        }
    }

    public List<EcranResultatQueryDTO> findbyidecran(UUID id){
        List<EcranResultatQueryDTO> plist = new ArrayList<>();
        ecranResultatRepository.findAllByEcranResultatID_IdEcran(id).forEach(ecranResultat -> {
            plist.add(new EcranResultatQueryDTO(
                    ecranResultat.getEcranResultatID().getIdEcran(),
                    ecranRepository.findById(ecranResultat.getEcranResultatID().getIdEcran()).get().getNomEcran(),
                    ecranResultat.getEcranResultatID().getIdCours(),
                    coursRepository.findById(ecranResultat.getEcranResultatID().getIdCours()).get().getNom()));
        });
        return plist;

    }
 /*   @Override
    public void updateEcranResultat(EcranResultatID id, EcranResultatQueryDTO ecranResultatQueryDTO) {
        EcranResultatID ecranResultatID = new EcranResultatID(
                ecranResultatQueryDTO.getIdEcran(),
                ecranResultatQueryDTO.getIdCours()
        );

        EcranResultat ecranResultat = new EcranResultat(ecranResultatID);

        ecranResultatRepository.save(ecranResultat);


    }*/

    @Override
    public void delete(EcranResultatID id) {
        this.ecranResultatRepository.delete(ecranResultatRepository.findById(id).get());
    }
}
