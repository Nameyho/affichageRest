package com.affichageRest.affichageRest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@IdClass(PersonResultat.class)
public class PersonResultat implements Serializable {

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
