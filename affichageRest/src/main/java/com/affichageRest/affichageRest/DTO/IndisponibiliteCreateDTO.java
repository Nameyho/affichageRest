package com.affichageRest.affichageRest.DTO;

import java.util.UUID;

public class IndisponibiliteCreateDTO {

    private UUID idindisponibilite;
    private String type;

    public IndisponibiliteCreateDTO(UUID idindisponibilite) {
        this.idindisponibilite = idindisponibilite;
    }

    public IndisponibiliteCreateDTO(UUID idindisponibilite, String type) {
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

