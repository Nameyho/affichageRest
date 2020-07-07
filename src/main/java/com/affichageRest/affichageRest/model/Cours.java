package com.affichageRest.affichageRest.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Period;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "Cours",schema = "public",catalog = "AffichageRest")
public class Cours implements Serializable {

    @Id
    @Column(name = "COURS_ID") private UUID id;

    @NotNull
    @NotEmpty
    private String nom;

    @NotNull
    private Date DateDebut;

    @NotNull
    private Date dateFin;

//    @OneToMany(mappedBy = "cours")
//    private Set<CoursEnseigne> courEnseignes;

    public Cours(String nom, Date dateDebut, Date datefin) {
        this.id = UUID.nameUUIDFromBytes((nom + dateDebut+datefin).getBytes());
        this.nom = nom;
        this.DateDebut= dateDebut;
        this.dateFin = datefin;
    }

    public Cours() {
    }

    @Override
    public String toString() {
        return "Cours{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", courEnseignes="  +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDebut() {
        return DateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        DateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cours cours = (Cours) o;
        return Objects.equals(id, cours.id) &&
                Objects.equals(nom, cours.nom)
              ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom);
    }
}
