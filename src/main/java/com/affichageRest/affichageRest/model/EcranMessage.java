package com.affichageRest.affichageRest.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class EcranMessage {

    @EmbeddedId
    EcranMessageID ecranMessageID;


    public EcranMessage(EcranMessageID ecranMessageID) {
        this.ecranMessageID = ecranMessageID;
    }

    public EcranMessage() {
    }

    public EcranMessageID getEcranMessageID() {
        return ecranMessageID;
    }

    public void setEcranMessageID(EcranMessageID ecranMessageID) {
        this.ecranMessageID = ecranMessageID;
    }
}
