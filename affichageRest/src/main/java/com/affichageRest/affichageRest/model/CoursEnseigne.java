package com.affichageRest.affichageRest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@IdClass(CoursEnseigne.class)
public class CoursEnseigne implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "PERSON")
    private Person person;

    @Id
    @ManyToOne
    @JoinColumn(name = "Cours")
    private Cours cours;

    private Date annee;

    public CoursEnseigne() {
    }

    public CoursEnseigne(Person person, Cours cours, Date annee) {
        this.person = person;
        this.cours = cours;
        this.annee = annee;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public Date getAnnee() {
        return annee;
    }

    public void setAnnee(Date annee) {
        this.annee = annee;
    }
}
