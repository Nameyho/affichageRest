package com.affichageRest.affichageRest.model;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;

public class PersonResultat {

    @Id
    @ManyToOne
    @JoinColumn(name = "PERSON")
    private Person person;

    @Id
    @ManyToOne
    @JoinColumn(name = "Cours")
    private Cours cours;

    private Date debut;
    private Date fin;

}
