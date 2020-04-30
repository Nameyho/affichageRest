package com.affichageRest.affichageRest.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "Person",schema = "public",catalog = "AffichageRest")


public class Person implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column (name="PERSON_ID") private UUID idPerson;

    @NotNull
    @NotEmpty
    @Column private String prenom;

    @NotNull
    @NotEmpty
    @Column private String nom;

    @Email
    @NotNull
    @Column private String email;

    @Past
    @NotNull
    @Column private Date  dateAnniversaire;




    public Person() {
    }



    public UUID getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(UUID idPerson) {
        this.idPerson = idPerson;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateAnniversaire(Date dateAnniversaire) {
        this.dateAnniversaire = dateAnniversaire;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public Person(String prenom, String nom, String email, Date dateAnniversaire) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.dateAnniversaire = dateAnniversaire;
    }

    public Person(UUID idPerson, @NotNull @NotEmpty String prenom, @NotNull @NotEmpty String nom, @Email @NotNull String email, @Past @NotNull Date dateAnniversaire) {
        this.idPerson = idPerson;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.dateAnniversaire = dateAnniversaire;
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





    public UUID getId() {
        return idPerson;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateAnniversaire() {
        return dateAnniversaire;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


}
