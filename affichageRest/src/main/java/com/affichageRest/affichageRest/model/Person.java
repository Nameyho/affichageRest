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
    private Role role;

    @OneToMany(mappedBy="person")
    private Set<Message> message;

    @OneToMany(mappedBy = "person")
    private Set<CoursEnseigne> courEnseignes;

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
                ", role=" + role +
                ", message=" + message +
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
                role.equals(person.role) &&
                message.equals(person.message) &&
                courEnseignes.equals(person.courEnseignes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prenom, nom, email, dateAnniversaire, role, message, courEnseignes);
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
