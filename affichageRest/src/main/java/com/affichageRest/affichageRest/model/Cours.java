package com.affichageRest.affichageRest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Cours")
public class Cours implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "COURS_ID") private Long id;

    private String nom;

    @OneToMany(mappedBy = "cours")
    private Set<CoursEnseigne> courEnseignes;

}
