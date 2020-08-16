package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DAO.*;
import com.affichageRest.affichageRest.DTO.EcranAbsenceQueryDTO;
import com.affichageRest.affichageRest.model.EcranAbsence;
import com.affichageRest.affichageRest.model.EcranAbsenceID;
import com.affichageRest.affichageRest.model.PersonIndisponibilitePK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @Autowired
    private PersonIndisponibiliteRepository personIndisponibiliteRepository;

    @Override
    public List<EcranAbsenceQueryDTO> getAllEcran() {
        List<EcranAbsenceQueryDTO> plist = new ArrayList<>();
        ecranAbsenceRepository.findAll().forEach(ecranAbsence -> {
            PersonIndisponibilitePK id = new PersonIndisponibilitePK( ecranAbsence.getEcranAbsenceID().getIdPerson(),
                    ecranAbsence.getEcranAbsenceID().getIdIndisponibilite(), ecranAbsence.getEcranAbsenceID().getIdSpecifique());
            plist.add(new EcranAbsenceQueryDTO(
                    ecranAbsence.getEcranAbsenceID().getIdEcran(),
                    ecranRepository.findById(ecranAbsence.getEcranAbsenceID().getIdEcran()).get().getNomEcran(),
                    ecranAbsence.getEcranAbsenceID().getIdIndisponibilite(),
                    indisponibiliteRepository.findById(ecranAbsence.getEcranAbsenceID().getIdIndisponibilite()).get().getType(),
                    ecranAbsence.getEcranAbsenceID().getIdPerson(),
                    personRepository.findById(ecranAbsence.getEcranAbsenceID().getIdPerson()).get().getNom(),
                    personRepository.findById(ecranAbsence.getEcranAbsenceID().getIdPerson()).get().getPrenom(),

                    personIndisponibiliteRepository.findById(id).get().getDateDebut(),
                    personIndisponibiliteRepository.findById(id).get().getDateFin(),


                    ecranAbsence.getEcranAbsenceID().getIdSpecifique()));

        });
        return plist;
    }
    @Override
    public List<EcranAbsenceQueryDTO> findAllByEcranAbsenceID_IdEcran(UUID uuid){
        List<EcranAbsenceQueryDTO> plist = new ArrayList<>();
        ecranAbsenceRepository.findAllByEcranAbsenceID_IdEcran(uuid).forEach(ecranAbsence -> {
            PersonIndisponibilitePK id = new PersonIndisponibilitePK( ecranAbsence.getEcranAbsenceID().getIdPerson(),
                    ecranAbsence.getEcranAbsenceID().getIdIndisponibilite(), ecranAbsence.getEcranAbsenceID().getIdSpecifique());
            plist.add(new EcranAbsenceQueryDTO(
                    ecranAbsence.getEcranAbsenceID().getIdEcran(),
                    ecranRepository.findById(ecranAbsence.getEcranAbsenceID().getIdEcran()).get().getNomEcran(),
                    ecranAbsence.getEcranAbsenceID().getIdIndisponibilite(),
                    indisponibiliteRepository.findById(ecranAbsence.getEcranAbsenceID().getIdIndisponibilite()).get().getType(),
                    ecranAbsence.getEcranAbsenceID().getIdPerson(),
                    personRepository.findById(ecranAbsence.getEcranAbsenceID().getIdPerson()).get().getNom(),
                    personRepository.findById(ecranAbsence.getEcranAbsenceID().getIdPerson()).get().getPrenom(),

                    personIndisponibiliteRepository.findById(id).get().getDateDebut(),
                    personIndisponibiliteRepository.findById(id).get().getDateFin(),
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
