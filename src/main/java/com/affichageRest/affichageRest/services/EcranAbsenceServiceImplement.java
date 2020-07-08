package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DAO.EcranAbsenceRepository;
import com.affichageRest.affichageRest.DAO.EcranRepository;
import com.affichageRest.affichageRest.DAO.IndisponibiliteRepository;
import com.affichageRest.affichageRest.DAO.PersonRepository;
import com.affichageRest.affichageRest.DTO.EcranAbsenceQueryDTO;
import com.affichageRest.affichageRest.model.EcranAbsence;
import com.affichageRest.affichageRest.model.EcranAbsenceID;
import com.affichageRest.affichageRest.model.PersonIndisponibilitePK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "EcranAbsenceService")
public class EcranAbsenceServiceImplement implements EcranAbsenceService {


    @Autowired
    private EcranAbsenceRepository ecranAbsenceRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private IndisponibiliteRepository indisponibiliteRepository;

    @Autowired
    private EcranRepository ecranRepository;

    @Override
    public List<EcranAbsenceQueryDTO> getAllEcran() {
        List<EcranAbsenceQueryDTO> plist = new ArrayList<>();
        ecranAbsenceRepository.findAll().forEach(ecranAbsence -> {

            plist.add(new EcranAbsenceQueryDTO(
                    ecranAbsence.getEcranAbsenceID().getIdEcran(),
                    ecranRepository.findById(ecranAbsence.getEcranAbsenceID().getIdEcran()).get().getNomEcran(),
                    ecranAbsence.getEcranAbsenceID().getIdIndisponibilite(),
                    indisponibiliteRepository.findById(ecranAbsence.getEcranAbsenceID().getIdIndisponibilite()).get().getType(),
                    ecranAbsence.getEcranAbsenceID().getIdPerson(),
                    personRepository.findById(ecranAbsence.getEcranAbsenceID().getIdPerson()).get().getNom(),
                    ecranAbsence.getEcranAbsenceID().getIdSpecifique()));

        });
        return plist;
    }

    @Override
    public EcranAbsenceQueryDTO createEcranAbsence(EcranAbsenceQueryDTO ecranAbsenceQueryDTO) {

        PersonIndisponibilitePK personIndisponibilitePK = new PersonIndisponibilitePK(
                ecranAbsenceQueryDTO.getIdPerson(),
                ecranAbsenceQueryDTO.getIdIndisponibilite(),

                ecranAbsenceQueryDTO.getIdSpecifique()
        );

        EcranAbsenceID ecranAbsenceID = new EcranAbsenceID(
                ecranAbsenceQueryDTO.getIdEcran(), personIndisponibilitePK

        );

        EcranAbsence ecranAbsence = new EcranAbsence(ecranAbsenceID);

        ecranAbsenceRepository.save(ecranAbsence);

        return ecranAbsenceQueryDTO;

    }

    @Override
    public EcranAbsenceQueryDTO getEcranAbsence(EcranAbsenceID id) {
        if (ecranAbsenceRepository.findById(id).isPresent()) {

            EcranAbsence ecranAbsence = ecranAbsenceRepository.findById(id).get();

            return new EcranAbsenceQueryDTO(
                    ecranAbsence.getEcranAbsenceID().getIdEcran(),
                    ecranRepository.findById(ecranAbsence.getEcranAbsenceID().getIdEcran()).get().getNomEcran(),
                    ecranAbsence.getEcranAbsenceID().getIdIndisponibilite(),
                    indisponibiliteRepository.findById(ecranAbsence.getEcranAbsenceID().getIdIndisponibilite()).get().getType(),
                    ecranAbsence.getEcranAbsenceID().getIdPerson(),
                    personRepository.findById(ecranAbsence.getEcranAbsenceID().getIdPerson()).get().getNom(),
                    ecranAbsence.getEcranAbsenceID().getIdSpecifique());
        } else {
            return null;
        }


    }

    @Override
    public void updateEcranAbsence(EcranAbsenceID id, EcranAbsenceQueryDTO ecranAbsenceQueryDTO) {


        PersonIndisponibilitePK personIndisponibilitePK = new PersonIndisponibilitePK(
                ecranAbsenceQueryDTO.getIdIndisponibilite(),
                ecranAbsenceQueryDTO.getIdPerson(),
                ecranAbsenceQueryDTO.getIdSpecifique()
        );

        EcranAbsenceID ecranAbsenceID = new EcranAbsenceID(
                ecranAbsenceQueryDTO.getIdEcran(), personIndisponibilitePK

        );

        EcranAbsence ecranAbsence = new EcranAbsence(ecranAbsenceID);

        ecranAbsenceRepository.save(ecranAbsence);


    }

    @Override
    public void delete(EcranAbsenceID id) {

        this.ecranAbsenceRepository.delete(ecranAbsenceRepository.findById(id).get());
    }
}
