package com.affichageRest.affichageRest.DTO;

import java.util.UUID;

public class EcranResultatQueryDTO {

    private UUID idEcran;
    private String nomEcran;

    private UUID idPerson;
    private String nomPerson;

    private UUID idCours;
    private String nomCours;


    public EcranResultatQueryDTO(UUID idEcran, String nomEcran, UUID idPerson, String nomPerson, UUID idCours, String nomCours) {
        this.idEcran = idEcran;
        this.nomEcran = nomEcran;
        this.idPerson = idPerson;
        this.nomPerson = nomPerson;
        this.idCours = idCours;
        this.nomCours = nomCours;
    }

    public EcranResultatQueryDTO(UUID idEcran, UUID idPerson, UUID idCours) {
        this.idEcran = idEcran;
        this.idPerson = idPerson;
        this.idCours = idCours;
    }

    public EcranResultatQueryDTO() {
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

    public UUID getIdCours() {
        return idCours;
    }

    public void setIdCours(UUID idCours) {
        this.idCours = idCours;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }
}
