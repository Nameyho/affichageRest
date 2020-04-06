package com.affichageRest.affichageRest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@IdClass(PersonIndisponibilite.class)
public class PersonIndisponibilite implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @Id
    @ManyToOne
    @JoinColumn(name = "Indisponibilité")
    private Indisponibilite indispo;

    private Date annee;
    private int resultat;
    private boolean reussite;

}
