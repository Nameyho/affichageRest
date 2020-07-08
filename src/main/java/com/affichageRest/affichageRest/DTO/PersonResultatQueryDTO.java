package com.affichageRest.affichageRest.DTO;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

public class PersonResultatQueryDTO {

    private UUID idPerson;
    private String nomPerson;
    private String prenomPerson;

    @NotNull
    private UUID cours_id;
    private String nomCours;

    private int resultat;
    private boolean reussite;

    public PersonResultatQueryDTO(UUID idPerson, UUID idCours, int resultat, boolean reussite) {
        this.idPerson = idPerson;
        this.cours_id = idCours;
        this.resultat = resultat;
        this.reussite = reussite;
    }

    public PersonResultatQueryDTO(UUID idPerson, String nomPerson,
                                  String prenomPerson, @NotNull UUID cours_id,
                                  String nomCours, int resultat, boolean reussite) {
        this.idPerson = idPerson;
        this.nomPerson = nomPerson;
        this.prenomPerson = prenomPerson;
        this.cours_id = cours_id;
        this.nomCours = nomCours;
        this.resultat = resultat;
        this.reussite = reussite;
    }

    public PersonResultatQueryDTO(UUID idPerson, String nomPerson,
                                  @NotNull UUID cours_id, String nomCours,
                                  int resultat, boolean reussite) {
        this.idPerson = idPerson;
        this.nomPerson = nomPerson;
        this.cours_id = cours_id;
        this.nomCours = nomCours;
        this.resultat = resultat;
        this.reussite = reussite;
    }

    public PersonResultatQueryDTO() {
        this.resultat = resultat;
        this.reussite = reussite;
    }

    public PersonResultatQueryDTO(Date annee, int resultat, boolean reussite) {
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public String getNomPerson() {
        return nomPerson;
    }

    public void setNomPerson(String nomPerson) {
        this.nomPerson = nomPerson;
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

    public String getPrenomPerson() {
        return prenomPerson;
    }

    public void setPrenomPerson(String prenomPerson) {
        this.prenomPerson = prenomPerson;
    }
}

