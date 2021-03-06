package com.affichageRest.affichageRest.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity(name = "resultat")
public class PersonResultat implements Serializable {


    @EmbeddedId
    private PersonResultatPK personResultatPK;

    @Min(0)
    private int resultat;

    private boolean reussite;

    public PersonResultat() {
    }

    public PersonResultat(PersonResultatPK personResultatPK, int resultat, boolean reussite) {

        this.personResultatPK = personResultatPK;
        this.resultat = resultat;
        this.reussite = reussite;
    }


    public PersonResultatPK getPersonResultatPK() {
        return personResultatPK;
    }

    public void setPersonResultatPK(PersonResultatPK personResultatPK) {
        this.personResultatPK = personResultatPK;
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
