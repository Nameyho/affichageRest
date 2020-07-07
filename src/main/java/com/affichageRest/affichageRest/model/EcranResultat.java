package com.affichageRest.affichageRest.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class EcranResultat {

    @EmbeddedId
    private EcranResultatID ecranResultatID;

    public EcranResultat(EcranResultatID ecranResultatID) {
        this.ecranResultatID = ecranResultatID;
    }

    public EcranResultatID getEcranResultatID() {
        return ecranResultatID;
    }

    public void setEcranResultatID(EcranResultatID ecranResultatID) {
        this.ecranResultatID = ecranResultatID;
    }
}
