package com.affichageRest.affichageRest.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class PersonIndisponibilite implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "PERSON")
    private Person person;

    @Id
    @ManyToOne
    @JoinColumn(name = "Indisponibilité")
    private Indisponibilite indispo;

    private Date annee;
    private int resultat;
    private boolean reussite;

}
