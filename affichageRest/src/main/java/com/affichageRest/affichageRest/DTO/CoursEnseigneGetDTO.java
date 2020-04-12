package com.affichageRest.affichageRest.DTO;

import java.sql.Date;
import java.util.UUID;

public class CoursEnseigneGetDTO {

    private UUID idPerson;
    private UUID idCours;

    private Date annee;

    public CoursEnseigneGetDTO() {
    }

    public CoursEnseigneGetDTO(UUID idPerson, UUID idCours, Date annee) {
        this.idPerson = idPerson;
        this.idCours = idCours;
        this.annee = annee;
    }

    public UUID getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(UUID idPerson) {
        this.idPerson = idPerson;
    }

    public UUID getIdCours() {
        return idCours;
    }

    public void setIdCours(UUID idCours) {
        this.idCours = idCours;
    }

    public Date getAnnee() {
        return annee;
    }

    public void setAnnee(Date annee) {
        this.annee = annee;
    }
}
