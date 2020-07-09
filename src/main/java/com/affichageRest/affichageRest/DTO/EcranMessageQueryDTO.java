package com.affichageRest.affichageRest.DTO;

import java.util.UUID;

public class EcranMessageQueryDTO {

    private UUID idEcran;
    private String nomEcran;


    private UUID idMessage;
    private String titreMessage;


    public EcranMessageQueryDTO() {
    }

    public EcranMessageQueryDTO(UUID idEcran, String nomEcran, UUID idMessage, String titreMessage) {
        this.idEcran = idEcran;
        this.nomEcran = nomEcran;
        this.idMessage = idMessage;
        this.titreMessage = titreMessage;
    }

    public UUID getIdEcran() {
        return idEcran;
    }

    public void setIdEcran(UUID idEcran) {
        this.idEcran = idEcran;
    }

    public String getNomEcran() {
        return nomEcran;
    }

    public void setNomEcran(String nomEcran) {
        this.nomEcran = nomEcran;
    }

    public UUID getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(UUID idMessage) {
        this.idMessage = idMessage;
    }

    public String getTitreMessage() {
        return titreMessage;
    }

    public void setTitreMessage(String titreMessage) {
        this.titreMessage = titreMessage;
    }
}
