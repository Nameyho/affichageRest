package com.affichageRest.affichageRest.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "resultat")
public class PersonResultat implements Serializable {


    @EmbeddedId
    private PersonResultatPK personResultatPK;


    private Date annee;

    @Min(0)
    private int resultat;



    private boolean reussite;

    public PersonResultat() {
    }

    public PersonResultat(PersonResultatPK personResultatPK, Date annee, int resultat, boolean reussite) {

        this.personResultatPK= personResultatPK;
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void setReussite(boolean reussite) {
        this.reussite = reussite;
    }
}
