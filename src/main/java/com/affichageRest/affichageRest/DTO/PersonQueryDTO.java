package com.affichageRest.affichageRest.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.UUID;

public class PersonQueryDTO {

    @NotNull
    @NotEmpty
    public String prenom;

    @NotNull
    @NotEmpty
    private String nom;

    @Email
    @NotNull
    private String email;

    @Past
    private Date dateAnniversaire;

    @NotNull
    @NotEmpty
    private UUID idPerson;

    private UUID idRole;

    private String nomRoles;

    public PersonQueryDTO(UUID idPerson, String prenom, String nom, String email, Date dateAnniversaire, UUID role, String nomrole) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.dateAnniversaire = dateAnniversaire;
        this.idRole = role;
        this.idPerson = idPerson;
        this.nomRoles = nomrole;


    }

    public PersonQueryDTO() {
    }

    public String getNomRoles() {
        return nomRoles;
    }

    public void setNomRoles(String nomRoles) {
        this.nomRoles = nomRoles;
    }

    public UUID getIdRole() {
        return idRole;
    }

    public void setIdRole(UUID idRole) {
        this.idRole = idRole;
    }

    public UUID getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(UUID idPerson) {
        this.idPerson = idPerson;
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
