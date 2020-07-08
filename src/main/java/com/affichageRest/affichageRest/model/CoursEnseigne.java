package com.affichageRest.affichageRest.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class CoursEnseigne implements Serializable {


    @EmbeddedId
    private CoursEnseigneID enseigneID;


    @NotNull
    private Date anneeDebut;

    @NotNull
    private Date anneeFin;

    public CoursEnseigne() {
    }

    public CoursEnseigne(CoursEnseigneID enseigneID, Date anneeDebut, Date anneeFin) {
        this.enseigneID = enseigneID;
        this.anneeDebut = anneeDebut;
        this.anneeFin = anneeFin;

    }

    public Date getAnneeDebut() {
        return anneeDebut;
    }

    public void setAnneeDebut(Date anneeDebut) {
        this.anneeDebut = anneeDebut;
    }

    public Date getAnneeFin() {
        return anneeFin;
    }

    public void setAnneeFin(Date anneeFin) {
        this.anneeFin = anneeFin;
    }


    public CoursEnseigneID getEnseigneID() {
        return enseigneID;
    }

    public void setEnseigneID(CoursEnseigneID enseigneID) {
        this.enseigneID = enseigneID;
    }


}

