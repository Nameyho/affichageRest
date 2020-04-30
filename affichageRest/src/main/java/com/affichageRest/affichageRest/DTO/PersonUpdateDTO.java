package com.affichageRest.affichageRest.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.UUID;

public class PersonUpdateDTO {

    @NotNull
    @NotEmpty
    private String prenom;

    @NotNull
    @NotEmpty
    private String nom;

    @Email
    @NotNull
    private String email;

    @Past
    private Date dateAnniversaire;


    private UUID idRole ;

    public PersonUpdateDTO(String prenom, String nom, String email, Date dateAnniversaire, String mdp) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.dateAnniversaire = dateAnniversaire;


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