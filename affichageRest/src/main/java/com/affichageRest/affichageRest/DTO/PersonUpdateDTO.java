package com.affichageRest.affichageRest.DTO;

import com.affichageRest.affichageRest.model.Roles;

import java.util.Date;

public class PersonUpdateDTO {

    private String prenom;
    private String nom;
    private String email;
    private Date dateAnniversaire;

    private long idRole ;

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

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRoles) {
        this.idRole = idRoles;
    }
}