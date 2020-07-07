package com.affichageRest.affichageRest.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class EcranResultatID implements Serializable {

    private UUID idEcran;
    private UUID idPerson;
    private UUID idCours;

    public EcranResultatID() {
    }

    public EcranResultatID(UUID idEcran, CoursEnseigneID coursEnseigneID){
    this.idEcran =idEcran;
    this.idPerson = coursEnseigneID.getIdPerson();
    this.idCours = coursEnseigneID.getIdCours();
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

    public UUID getIdCours() {
        return idCours;
    }

    public void setIdCours(UUID idCours) {
        this.idCours = idCours;
    }
}
