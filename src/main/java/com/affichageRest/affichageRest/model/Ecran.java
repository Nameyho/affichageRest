package com.affichageRest.affichageRest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Ecran {

    @Id
    private UUID idEcran;

    @Column(unique = true)
    private String nomEcran;

    public Ecran() {
        this.idEcran = UUID.randomUUID();
    }

    public Ecran(String nomecran) {
        this.idEcran = UUID.nameUUIDFromBytes(nomecran.getBytes());
        this.nomEcran = nomecran;
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
