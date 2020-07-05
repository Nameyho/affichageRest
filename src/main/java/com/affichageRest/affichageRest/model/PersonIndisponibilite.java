package com.affichageRest.affichageRest.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PersonIndisponibilite {


    @EmbeddedId
    private PersonIndisponibilitePK personIndisponibilitePK;


    private Date dateDebut;
    private Date dateFin;


    public PersonIndisponibilite() {
    }

    public PersonIndisponibilite(PersonIndisponibilitePK personIndisponibilitePK, Date dateDebut, Date dateFin) {
        this.personIndisponibilitePK = personIndisponibilitePK;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public PersonIndisponibilitePK getPersonIndisponibilitePK() {
        return personIndisponibilitePK;
    }

    public void setPersonIndisponibilitePK(PersonIndisponibilitePK personIndisponibilitePK) {
        this.personIndisponibilitePK = personIndisponibilitePK;
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
