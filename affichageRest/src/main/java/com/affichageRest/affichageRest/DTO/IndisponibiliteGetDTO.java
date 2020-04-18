package com.affichageRest.affichageRest.DTO;

import java.util.UUID;

public class IndisponibiliteGetDTO {

    private UUID idindisponibilite;
    private String type;

    public IndisponibiliteGetDTO(UUID idindisponibilite) {
        this.idindisponibilite = idindisponibilite;
    }

    public IndisponibiliteGetDTO(UUID idindisponibilite, String type) {
        this.idindisponibilite = idindisponibilite;
        this.type = type;
    }

    public UUID getIdindisponibilite() {
        return idindisponibilite;
    }

    public void setIdindisponibilite(UUID idindisponibilite) {
        this.idindisponibilite = idindisponibilite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

