package com.affichageRest.affichageRest.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class EcranAbsenceID implements Serializable {
    private UUID idEcran;
    private UUID idPerson;
    private UUID idIndisponibilite;
    private UUID idSpecifique;

    public EcranAbsenceID() {
    }

    public EcranAbsenceID(UUID idEcran, PersonIndisponibilitePK idAbsence) {
        this.idEcran = idEcran;
        this.idPerson = idAbsence.getIdPerson();
        this.idIndisponibilite=idAbsence.getIndispo_id();
        this.idSpecifique=idAbsence.getIdSpecifique();
    }

    public UUID getIdEcran() {
        return idEcran;
    }

    public void setIdEcran(UUID idEcran) {
        this.idEcran = idEcran;
    }

    public UUID getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(UUID idPerson) {
        this.idPerson = idPerson;
    }

    public UUID getIdIndisponibilite() {
        return idIndisponibilite;
    }

    public void setIdIndisponibilite(UUID idIndisponibilite) {
        this.idIndisponibilite = idIndisponibilite;
    }

    public UUID getIdSpecifique() {
        return idSpecifique;
    }

    public void setIdSpecifique(UUID idSpecifique) {
        this.idSpecifique = idSpecifique;
    }
}
