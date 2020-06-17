package com.affichageRest.affichageRest.DTO;

import java.util.Date;
import java.util.UUID;

public class CoursEnseigneQueryDTO {


    private UUID idPerson;
    private UUID idCours;

    private Date anneeDebut;
    private Date anneeFin;

    private String nomCours;
    private String nomPerson;

    public CoursEnseigneQueryDTO() {
    }

    public CoursEnseigneQueryDTO(UUID idPerson, UUID idCours, Date anneeDebut, Date anneeFin, String nomCours, String nomPerson) {
        this.idPerson = idPerson;
        this.idCours = idCours;
        this.anneeDebut = anneeDebut;
        this.anneeFin = anneeFin;
        this.nomCours = nomCours;
        this.nomPerson = nomPerson;
    }

    public UUID getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(UUID idPerson) {
        this.idPerson = idPerson;
    }

    public UUID getIdCours() {
        return idCours;
    }

    public void setIdCours(UUID idCours) {
        this.idCours = idCours;
    }

    public Date getAnneeDebut() {
        return anneeDebut;
    }

    public void setAnneeDebut(Date anneeDebut) {
        this.anneeDebut = anneeDebut;
    }

    public Date getAnneeFin() {
        return anneeFin;
    }

    public void setAnneeFin(Date anneeFin) {
        this.anneeFin = anneeFin;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public String getNomPerson() {
        return nomPerson;
    }

    public void setNomPerson(String nomPerson) {
        this.nomPerson = nomPerson;
    }
}
