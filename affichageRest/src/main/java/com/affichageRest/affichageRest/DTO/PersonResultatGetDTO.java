package com.affichageRest.affichageRest.DTO;

import java.sql.Date;
import java.util.UUID;

public class PersonResultatGetDTO {

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

