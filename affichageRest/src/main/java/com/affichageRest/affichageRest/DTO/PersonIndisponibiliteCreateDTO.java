package com.affichageRest.affichageRest.DTO;

import java.util.Date;
import java.util.UUID;

public class PersonIndisponibiliteCreateDTO {

    private UUID idPerson;
    private UUID indispo_id;
    private UUID idCours;

    private Date dateDebut;

    private Date dateFin;

    public PersonIndisponibiliteCreateDTO() {
    }

    public PersonIndisponibiliteCreateDTO(UUID idPerson, UUID indispo_id, UUID idCours, Date dateDebut, Date dateFin) {
        this.idPerson = idPerson;
        this.indispo_id = indispo_id;
        this.idCours = idCours;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public UUID getIndispo_id() {
        return indispo_id;
    }

    public void setIndispo_id(UUID indispo_id) {
        this.indispo_id = indispo_id;
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
