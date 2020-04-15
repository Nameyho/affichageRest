package com.affichageRest.affichageRest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
public class Indisponibilite implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "COURS_ID") private UUID idCours;


//    @OneToMany(mappedBy = "person")
//    private Set<CoursEnseigne> courEnseignes;

    @OneToMany(mappedBy = "person")
    private Set<PersonIndisponibilite> personIndisponibilites;

    public Indisponibilite(UUID id, Set<CoursEnseigne> courEnseignes, Set<PersonIndisponibilite> personIndisponibilites, String type) {
        this.idCours = id;

        this.personIndisponibilites = personIndisponibilites;
        this.type = type;
    }

    public Indisponibilite() {
    }

    public UUID getId() {
        return idCours;
    }

    public void setId(UUID id) {
        this.idCours = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

}
