package com.affichageRest.affichageRest.model;

import org.hibernate.annotations.Type;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class PersonIndisponibilitePK implements Serializable {
    @Type(type="pg-uuid")
    private UUID idPerson;
    private UUID indispo_id;
    private UUID idCours;

    public PersonIndisponibilitePK() {
    }

    public PersonIndisponibilitePK(UUID idPerson, UUID indispo_id, UUID idCours) {
        this.idPerson = idPerson;
        this.indispo_id = indispo_id;
        this.idCours = idCours;
    }

    public UUID getIndispo_id() {
        return indispo_id;
    }

    public void setIndispo_id(UUID indispo_id) {
        this.indispo_id = indispo_id;
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void setIdCours(UUID idCours) {
        this.idCours = idCours;
    }
}
