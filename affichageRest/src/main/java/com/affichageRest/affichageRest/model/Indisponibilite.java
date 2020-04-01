package com.affichageRest.affichageRest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Indisponibilite implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "COURS_ID") private Long id;


    @OneToMany(mappedBy = "person")
    private Set<CoursEnseigne> courEnseignes;

    @OneToMany(mappedBy = "person")
    private Set<PersonIndisponibilite> personIndisponibilites;

    public Indisponibilite(Long id, Set<CoursEnseigne> courEnseignes, Set<PersonIndisponibilite> personIndisponibilites, String type) {
        this.id = id;
        this.courEnseignes = courEnseignes;
        this.personIndisponibilites = personIndisponibilites;
        this.type = type;
    }

    public Indisponibilite() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

}
