package com.affichageRest.affichageRest.DTO;

import java.util.Date;
import java.util.UUID;

public class MessageQueryDTO {

    public String contenu;
    public Date createdDate;
    private UUID idMessage;
    private String nomPerson;
    private UUID idPerson;
    private String titreMessage;


    public MessageQueryDTO(UUID idMessage, String contenu, Date createdDate, UUID idperson) {
        this.idMessage = idMessage;
        this.contenu = contenu;
        this.createdDate = createdDate;
        this.idPerson = idperson;

    }

    public MessageQueryDTO(UUID idMessage, String contenu, Date createdDate, UUID idperson, String nomPerso, String titreMessage) {
        this.idMessage = idMessage;
        this.contenu = contenu;
        this.createdDate = createdDate;
        this.idPerson = idperson;
        this.nomPerson = nomPerso;
        this.titreMessage = titreMessage;
    }

    public MessageQueryDTO() {
    }

    public String getTitreMessage() {
        return titreMessage;
    }

    public void setTitreMessage(String titreMessage) {
        this.titreMessage = titreMessage;
    }

    public UUID getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(UUID idMessage) {
        this.idMessage = idMessage;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public UUID getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(UUID idPerson) {
        this.idPerson = idPerson;
    }

    public String getNomPerson() {
        return nomPerson;
    }

    public void setNomPerson(String nomPerson) {
        this.nomPerson = nomPerson;
    }
}
