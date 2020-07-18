package com.affichageRest.affichageRest.DTO;

import java.util.UUID;

public class EcranQueryDTO {

    private UUID idEcran;
    private String nomEcran;

    public EcranQueryDTO() {
    }

    public EcranQueryDTO(UUID idEcran, String nomEcran) {
        this.idEcran = idEcran;
        this.nomEcran = nomEcran;
    }

    public UUID getIdEcran() {
        return idEcran;
    }

    public void setIdEcran(UUID idEcran) {
        this.idEcran = idEcran;
    }

    public String getNomEcran() {
        return nomEcran;
    }

    public void setNomEcran(String nomEcran) {
        this.nomEcran = nomEcran;
    }
}
