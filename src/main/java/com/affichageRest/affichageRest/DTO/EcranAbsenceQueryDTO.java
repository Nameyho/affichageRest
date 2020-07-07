package com.affichageRest.affichageRest.DTO;

import java.util.UUID;

public class EcranAbsenceQueryDTO {

    private UUID idEcran;
    private String nomEcran;

    private UUID idIndisponibilite;
    private String nomIndiponibilite;

    private UUID idPerson;
    private String nomPerson;

    private UUID idSpecifique;

    public EcranAbsenceQueryDTO(UUID idEcran,
                                String nomEcran,
                                UUID idIndisponibilite,
                                String nomIndiponibilite,
                                UUID idPerson,
                                String nomPerson,
                                UUID idSpecifique) {
        this.idEcran = idEcran;
        this.nomEcran = nomEcran;
        this.idIndisponibilite = idIndisponibilite;
        this.nomIndiponibilite = nomIndiponibilite;
        this.idPerson = idPerson;
        this.nomPerson = nomPerson;
        this.idSpecifique = idSpecifique;
    }

    public EcranAbsenceQueryDTO(UUID idEcran, UUID idIndisponibilite, UUID idPerson, UUID idSpecifique) {
        this.idEcran = idEcran;
        this.idIndisponibilite = idIndisponibilite;
        this.idPerson = idPerson;
        this.idSpecifique = idSpecifique;
    }

    public EcranAbsenceQueryDTO() {
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

    public UUID getIdIndisponibilite() {
        return idIndisponibilite;
    }

    public void setIdIndisponibilite(UUID idIndisponibilite) {
        this.idIndisponibilite = idIndisponibilite;
    }

    public String getNomIndiponibilite() {
        return nomIndiponibilite;
    }

    public void setNomIndiponibilite(String nomIndiponibilite) {
        this.nomIndiponibilite = nomIndiponibilite;
    }

    public UUID getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(UUID idPerson) {
        this.idPerson = idPerson;
    }

    public String getNomPerson() {
        return nomPerson;
    }

    public void setNomPerson(String nomPerson) {
        this.nomPerson = nomPerson;
    }

    public UUID getIdSpecifique() {
        return idSpecifique;
    }

    public void setIdSpecifique(UUID idSpecifique) {
        this.idSpecifique = idSpecifique;
    }
}
