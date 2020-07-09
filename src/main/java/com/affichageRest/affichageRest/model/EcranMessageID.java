package com.affichageRest.affichageRest.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class EcranMessageID implements Serializable {

    private UUID idEcran;
    private UUID idMessage;

    public EcranMessageID() {
    }

    public EcranMessageID(UUID idEcran, UUID idMessage) {
        this.idEcran = idEcran;
        this.idMessage = idMessage;
    }

    public UUID getIdEcran() {
        return idEcran;
    }

    public void setIdEcran(UUID idEcran) {
        this.idEcran = idEcran;
    }

    public UUID getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(UUID idMessage) {
        this.idMessage = idMessage;
    }
}
