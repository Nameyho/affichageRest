package com.affichageRest.affichageRest.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "Person",schema = "public",catalog = "AffichageRest")


public class Person implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column (name="PERSON_ID") private UUID idPerson;
    @Column private String prenom;
    @Column private String nom;
    @Column private String email;
    @Column private Date  dateAnniversaire;

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }



    @Column private String motDePasse;





    private String username;

//    @OneToMany(mappedBy = "person")
//    private Set<CoursEnseigne> courEnseignes;

//    @OneToMany(mappedBy = "person")
//    private Set<PersonResultat> indisponibilites;

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
