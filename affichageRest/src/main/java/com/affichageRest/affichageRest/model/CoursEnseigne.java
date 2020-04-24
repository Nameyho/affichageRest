package com.affichageRest.affichageRest.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class CoursEnseigne implements Serializable {




    @EmbeddedId
    private CoursEnseigneID enseigneID;

    private Date annee;

    public CoursEnseigne() {
    }

    public CoursEnseigne(CoursEnseigneID enseigneID, Date annee) {
        this.enseigneID = enseigneID;
        this.annee = annee;
    }

    public CoursEnseigneID getEnseigneID() {
        return enseigneID;
    }

    public void setEnseigneID(CoursEnseigneID enseigneID) {
        this.enseigneID = enseigneID;
    }

    public Date getAnnee() {
        return annee;
    }

    public void setAnnee(Date annee) {
        this.annee = annee;
    }
}

