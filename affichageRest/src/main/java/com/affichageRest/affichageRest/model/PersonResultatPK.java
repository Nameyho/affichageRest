package com.affichageRest.affichageRest.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class PersonResultatPK implements Serializable {

    @Column(name = "PERSON_ID")
    public UUID idPerson;

    @Column(name = "COURS_ID")
    public UUID idCours;

    public PersonResultatPK() {
    }

    public PersonResultatPK(UUID idPerson, UUID idCours) {
        this.idPerson = idPerson;
        this.idCours = idCours;
    }

    public UUID getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(UUID idPerson) {
        this.idPerson = idPerson;
    }

    public UUID getIdCours() {
        return idCours;
    }

    public void setIdCours(UUID idCours) {
        this.idCours = idCours;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
