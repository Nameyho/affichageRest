package com.affichageRest.affichageRest.model;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
public class EcranAbsence {

    @EmbeddedId
    private EcranAbsenceID ecranAbsenceID;


    public EcranAbsence(EcranAbsenceID ecranAbsenceID) {
        this.ecranAbsenceID = ecranAbsenceID;
    }

    public EcranAbsence() {
    }

    public EcranAbsenceID getEcranAbsenceID() {
        return ecranAbsenceID;
    }

    public void setEcranAbsenceID(EcranAbsenceID ecranAbsenceID) {
        this.ecranAbsenceID = ecranAbsenceID;
    }
}

