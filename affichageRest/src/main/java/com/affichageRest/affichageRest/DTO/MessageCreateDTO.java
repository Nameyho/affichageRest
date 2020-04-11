package com.affichageRest.affichageRest.DTO;

import java.sql.Date;
import java.util.UUID;

public class MessageCreateDTO {

    public String contenu;
    public Date createdDate;

    private UUID idPerson;

    public MessageCreateDTO(String contenu, Date createdDate, UUID idPerson) {
        this.contenu = contenu;
        this.createdDate = createdDate;
        this.idPerson = idPerson;
    }

    public MessageCreateDTO() {
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
}
