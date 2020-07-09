package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DAO.EcranMessageRepository;
import com.affichageRest.affichageRest.DAO.MessageRepository;
import com.affichageRest.affichageRest.DAO.EcranRepository;
import com.affichageRest.affichageRest.DAO.EcranResultatRepository;
import com.affichageRest.affichageRest.DTO.EcranMessageQueryDTO;
import com.affichageRest.affichageRest.DTO.EcranResultatQueryDTO;
import com.affichageRest.affichageRest.model.EcranMessage;
import com.affichageRest.affichageRest.model.EcranMessageID;
import com.affichageRest.affichageRest.model.EcranResultat;
import com.affichageRest.affichageRest.model.EcranResultatID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "EcranMessageService")
public class EcranMessageServiceImplement implements EcranMessageService {


    @Autowired
    private EcranMessageRepository ecranMessageRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private EcranRepository ecranRepository;

    @Override
    public List<EcranMessageQueryDTO> getAllEcranMessage() {
        List<EcranMessageQueryDTO> plist = new ArrayList<>();
        ecranMessageRepository.findAll().forEach(ecranMessage -> {
            plist.add(new EcranMessageQueryDTO(
                    ecranMessage.getEcranMessageID().getIdEcran(),
                    ecranRepository.findById(ecranMessage.getEcranMessageID().getIdEcran()).get().getNomEcran(),
                    ecranMessage.getEcranMessageID().getIdMessage(),
                    messageRepository.findById(ecranMessage.getEcranMessageID().getIdMessage()).get().getTitreMessage()));
        });
        return plist;
    }

    @Override
    public EcranMessageQueryDTO createEcranMessage(EcranMessageQueryDTO ecranMessageQueryDTO) {


        EcranMessageID ecranMessageID = new EcranMessageID(
                ecranMessageQueryDTO.getIdEcran(),
                ecranMessageQueryDTO.getIdMessage()
        );

        EcranMessage ecranMessage = new EcranMessage(ecranMessageID);

        ecranMessageRepository.save(ecranMessage);

        return ecranMessageQueryDTO;
    }

    @Override
    public EcranMessageQueryDTO getEcranMessage(EcranMessageID id) {
        if (ecranMessageRepository.findById(id).isPresent()) {
            EcranMessage ecranMessage = ecranMessageRepository.findById(id).get();

            return new EcranMessageQueryDTO(
                    ecranMessage.getEcranMessageID().getIdEcran(),
                    ecranRepository.findById(ecranMessage.getEcranMessageID().getIdEcran()).get().getNomEcran(),
                    ecranMessage.getEcranMessageID().getIdMessage(),
                    messageRepository.findById(ecranMessage.getEcranMessageID().getIdMessage()).get().getTitreMessage());
        } else {
            return null;
        }
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
    public void delete(EcranMessageID id) {
        this.ecranMessageRepository.delete(ecranMessageRepository.findById(id).get());
    }
}
