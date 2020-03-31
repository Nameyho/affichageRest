package com.affichageRest.affichageRest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Cours",schema = "public",catalog = "AffichageRest")
public class Cours implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "COURS_ID") private Long id;

    private String nom;

    @OneToMany(mappedBy = "cours")
    private Set<CoursEnseigne> courEnseignes;

    public Cours(Long id, String nom) {
        this.id = id;
        this.nom = nom;

    }

    public Cours() {
    }

    @Override
    public String toString() {
        return "Cours{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", courEnseignes=" + courEnseignes +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cours cours = (Cours) o;
        return Objects.equals(id, cours.id) &&
                Objects.equals(nom, cours.nom) &&
                Objects.equals(courEnseignes, cours.courEnseignes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, courEnseignes);
    }
}
