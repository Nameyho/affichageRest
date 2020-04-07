package com.affichageRest.affichageRest.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "Person",schema = "public",catalog = "AffichageRest")


public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column (name="PERSON_ID") private UUID idPerson;
    @Column private String prenom;
    @Column private String nom;
    @Column private String email;
    @Column private Date  dateAnniversaire;


    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "idRole")
    private Roles role;

    @OneToMany(mappedBy="person")
    private Set<Messages> messages;

    @OneToMany(mappedBy = "person")
    private Set<CoursEnseigne> courEnseignes;

    @OneToMany(mappedBy = "person")
    private Set<PersonIndisponibilite> indisponibilites;

    public Person() {
    }

    public void setRole(Roles role) {
        this.role = role;
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
                ", role=" + role+
                ", message=" + messages +
                ", courEnseignes=" + courEnseignes +
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
                dateAnniversaire.equals(person.dateAnniversaire) &&
                messages.equals(person.messages) &&
                courEnseignes.equals(person.courEnseignes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerson, prenom, nom, email, dateAnniversaire, role, messages, courEnseignes);
    }

    public Roles getRole() {
        return role;
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



}
