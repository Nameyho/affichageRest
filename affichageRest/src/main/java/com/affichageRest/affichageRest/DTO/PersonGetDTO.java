package com.affichageRest.affichageRest.DTO;

import com.affichageRest.affichageRest.model.Roles;

import java.util.Date;
import java.util.UUID;

public class PersonGetDTO {

    private UUID idPerson;
    private String prenom;
    private String nom;
    private String email;
    private Date dateAnniversaire;

    private UUID idRole;

    public PersonGetDTO() {
    }

    public PersonGetDTO(UUID idperson, String prenom, String nom, String email, Date dateAnniversaire, UUID role) {
        this.idPerson = idperson;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.dateAnniversaire = dateAnniversaire;
        this.idRole = role;
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

    public UUID getidRole() {
        return idRole;
    }

    public void setRole(UUID role) {
        idRole = role;
    }

    public UUID getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(UUID idPerson) {
        this.idPerson = idPerson;
    }
}
