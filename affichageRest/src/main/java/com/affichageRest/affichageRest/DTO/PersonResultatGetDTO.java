package com.affichageRest.affichageRest.DTO;

import org.hibernate.annotations.Type;

import java.util.Date;
import java.util.UUID;

public class PersonResultatGetDTO {
    @Type(type="pg-uuid")
    private UUID idPerson;

    private UUID idCours;

    private Date annee;
    private int resultat;
    private boolean reussite;

    public PersonResultatGetDTO(UUID idPerson, UUID idCours, Date annee, int resultat, boolean reussite) {
        this.idPerson = idPerson;
        this.idCours = idCours;
        this.annee = annee;
        this.resultat = resultat;
        this.reussite = reussite;
    }

    public PersonResultatGetDTO() {
        this.annee = annee;
        this.resultat = resultat;
        this.reussite = reussite;
    }

    public PersonResultatGetDTO(Date annee, int resultat, boolean reussite) {
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

