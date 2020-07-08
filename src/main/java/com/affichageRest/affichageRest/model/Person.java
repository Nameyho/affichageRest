package com.affichageRest.affichageRest.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "Person", schema = "public", catalog = "AffichageRest")


public class Person implements Serializable {

    @Id

    @Column(name = "PERSON_ID", unique = true)
    private UUID idPerson;

    @NotNull
    @NotEmpty
    @Column
    private String prenom;

    @NotNull
    @NotEmpty
    @Column
    private String nom;

    @Email
    @NotNull
    @Column
    private String email;

    @Past
    @NotNull
    @Column
    private Date dateAnniversaire;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_role")
    private Role roles;


    public Person() {
    }

    public Person(UUID idPerson, String prenom, String nom, String email, Date dateAnniversaire, Role role) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.dateAnniversaire = dateAnniversaire;
        this.idPerson = idPerson;
        this.roles = roles;
    }

    public Person(String prenom, String nom, String email, Date dateAnniversaire, Role role) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.dateAnniversaire = dateAnniversaire;
        this.roles = role;
        this.idPerson = UUID.nameUUIDFromBytes((prenom + nom + dateAnniversaire).getBytes());
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + idPerson +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", dateAnniversaire=" + dateAnniversaire +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return idPerson.equals(person.idPerson) &&
                prenom.equals(person.prenom) &&
                nom.equals(person.nom) &&
                email.equals(person.email) &&
                dateAnniversaire.equals(person.dateAnniversaire)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerson, prenom, nom, email, dateAnniversaire);
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
