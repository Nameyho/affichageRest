package com.affichageRest.affichageRest.DTO;

import org.hibernate.annotations.Type;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

public class PersonResultatGetDTO {

    private UUID idPerson;
    private String nomCours;
    @NotNull
    private UUID cours_id;

    private Date annee;
    private int resultat;
    private boolean reussite;

    public PersonResultatGetDTO(UUID idPerson, UUID idCours, Date annee, int resultat, boolean reussite) {
        this.idPerson = idPerson;
        this.cours_id = idCours;
        this.annee = annee;
        this.resultat = resultat;
        this.reussite = reussite;
    }

    public PersonResultatGetDTO(UUID idPerson, String nomCours, UUID cours_id, Date annee, int resultat, boolean reussite) {
        this.idPerson = idPerson;
        this.nomCours = nomCours;
        this.cours_id = cours_id;
        this.annee = annee;
        this.resultat = resultat;
        this.reussite = reussite;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
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

    public UUID getCours_id() {
        return cours_id;
    }

    public void setCours_id(UUID cours_id) {
        this.cours_id = cours_id;
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

