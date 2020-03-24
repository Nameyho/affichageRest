package com.affichageRest.affichageRest.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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
