package com.affichageRest.affichageRest.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Indisponibilite implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "COURS_ID") private Long id;


    private String type;

}
