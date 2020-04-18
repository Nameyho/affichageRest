package com.affichageRest.affichageRest.DTO;

import java.util.Date;
import java.util.UUID;

public class PersonIndisponibiliteGetDTO {

    private UUID idPerson;

    private UUID idCours;

    private Date dateDebut;

    private Date dateFin;

    public PersonIndisponibiliteGetDTO() {
    }

    public PersonIndisponibiliteGetDTO(UUID idPerson, UUID idCours, Date dateDebut, Date dateFin) {
        this.idPerson = idPerson;
        this.idCours = idCours;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
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

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
