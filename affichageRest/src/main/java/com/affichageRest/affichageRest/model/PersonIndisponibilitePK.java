package com.affichageRest.affichageRest.model;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class PersonIndisponibilitePK implements Serializable {

    private UUID idPerson;

    private UUID idCours;

    public PersonIndisponibilitePK() {
    }

    public PersonIndisponibilitePK(UUID idPerson, UUID idCours) {
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
}
