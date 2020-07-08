package com.affichageRest.affichageRest.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class EcranResultatID implements Serializable {

    private UUID idEcran;
    private UUID idCours;

    public EcranResultatID() {
    }

    public EcranResultatID(UUID idEcran, UUID coursEnseigneID) {
        this.idEcran = idEcran;
        this.idCours = coursEnseigneID;
    }

    public UUID getIdEcran() {
        return idEcran;
    }

    public void setIdEcran(UUID idEcran) {
        this.idEcran = idEcran;
    }


    public UUID getIdCours() {
        return idCours;
    }

    public void setIdCours(UUID idCours) {
        this.idCours = idCours;
    }
}
