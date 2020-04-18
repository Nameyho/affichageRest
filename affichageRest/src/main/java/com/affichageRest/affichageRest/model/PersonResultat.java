package com.affichageRest.affichageRest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class PersonResultat implements Serializable {

//    @Id
//    @ManyToOne
//    @JoinColumn(name = "PERSON_ID")
//    private Person person;
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "Indisponibilité")
//    private Indisponibilite indispo;

    @EmbeddedId
    private PersonResultatPK personResultatPK;

    private Date annee;
    private int resultat;
    private boolean reussite;

    public PersonResultat() {
    }

    public PersonResultat(Person person, Indisponibilite indispo, Date annee, int resultat, boolean reussite) {

        this.annee = annee;
        this.resultat = resultat;
        this.reussite = reussite;
    }

    public PersonResultatPK getPersonResultatPK() {
        return personResultatPK;
    }

    public void setPersonResultatPK(PersonResultatPK personResultatPK) {
        this.personResultatPK = personResultatPK;
    }

    public Date getAnnee() {
        return annee;
    }

    public void setAnnee(Date annee) {
        this.annee = annee;
    }

    public int getResultat() {
        return resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }

    public boolean isReussite() {
        return reussite;
    }

    public void setReussite(boolean reussite) {
        this.reussite = reussite;
    }
}
