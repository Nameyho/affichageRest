package com.affichageRest.affichageRest.DTO;

import org.hibernate.annotations.Type;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

public class PersonResultatQueryDTO {

    private UUID idPerson;
    private String nomCours;
    @NotNull
    private UUID cours_id;

    private int resultat;
    private boolean reussite;

    public PersonResultatQueryDTO(UUID idPerson, UUID idCours, int resultat, boolean reussite) {
        this.idPerson = idPerson;
        this.cours_id = idCours;
        this.resultat = resultat;
        this.reussite = reussite;
    }

    public PersonResultatQueryDTO(UUID idPerson, String nomCours, UUID cours_id, int resultat, boolean reussite) {
        this.idPerson = idPerson;
        this.nomCours = nomCours;
        this.cours_id = cours_id;
        this.resultat = resultat;
        this.reussite = reussite;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public PersonResultatQueryDTO() {
        this.resultat = resultat;
        this.reussite = reussite;
    }

    public PersonResultatQueryDTO(Date annee, int resultat, boolean reussite) {
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

