package com.affichageRest.affichageRest.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;



@Entity
@Table(name = "Person",schema = "public",catalog = "AffichageRest")


public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column (name="PERSON_ID") private Long id;
    @Column private String prenom;
    @Column private String nom;
    @Column private String email;
    @Column private Date  dateAnniversaire;
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "Role_id")
    private Roles roles;

    @OneToMany(mappedBy="person")
    private Set<Messages> messages;

    @OneToMany(mappedBy = "person")
    private Set<CoursEnseigne> courEnseignes;

    @OneToMany(mappedBy = "person")
    private Set<PersonIndisponibilite> indisponibilites;

    public Person() {
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
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", dateAnniversaire=" + dateAnniversaire +
                ", role=" + roles +
                ", message=" + messages +
                ", courEnseignes=" + courEnseignes +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id) &&
                prenom.equals(person.prenom) &&
                nom.equals(person.nom) &&
                email.equals(person.email) &&
                dateAnniversaire.equals(person.dateAnniversaire) &&
                roles.equals(person.roles) &&
                messages.equals(person.messages) &&
                courEnseignes.equals(person.courEnseignes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prenom, nom, email, dateAnniversaire, roles, messages, courEnseignes);
    }

    public Roles getRoles() {
        return roles;
    }

    public Long getId() {
        return id;
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
