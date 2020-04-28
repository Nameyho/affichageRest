package com.affichageRest.affichageRest.DTO;

import java.util.Date;
import java.util.UUID;

public class PersonUpdateDTO {

    private String prenom;
    private String nom;
    private String email;
    private Date dateAnniversaire;
    private String mdp;
    private UUID idRole ;

    public PersonUpdateDTO(String prenom, String nom, String email, Date dateAnniversaire, String mdp) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.dateAnniversaire = dateAnniversaire;
        this.mdp = mdp;

    }


    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateAnniversaire() {
        return dateAnniversaire;
    }

    public void setDateAnniversaire(Date dateAnniversaire) {
        this.dateAnniversaire = dateAnniversaire;
    }
    }