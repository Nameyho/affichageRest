package com.affichageRest.affichageRest.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class IndisponibiliteQueryDTO {

    private UUID idindisponibilite;
    @NotNull
    @NotEmpty
    private String type;

    public IndisponibiliteQueryDTO(UUID idindisponibilite) {
        this.idindisponibilite = idindisponibilite;
    }

    public IndisponibiliteQueryDTO(UUID idindisponibilite, String type) {
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

