package com.affichageRest.affichageRest.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class CoursEnseigneID implements Serializable {



    private UUID idPerson;



    private UUID idCours;



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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoursEnseigneID that = (CoursEnseigneID) o;
        return Objects.equals(idPerson, that.idPerson) &&
                Objects.equals(idCours, that.idCours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerson, idCours);
    }


}