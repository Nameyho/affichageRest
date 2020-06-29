package com.affichageRest.affichageRest.DTO;

import java.util.Date;
import java.util.UUID;

public class PersonIndisponibiliteQueryDTO {

    private UUID idPerson;
    private UUID indispo_id;
    private UUID idCours;

    private Date dateDebut;

    private Date dateFin;

    private String nomPerson;
    private String nomIndispo;
    private String nomCours;
    private String prenomPerson;

    public PersonIndisponibiliteQueryDTO(UUID idPerson, UUID indispo_id, UUID idCours, Date dateDebut, Date dateFin,
                                         String nomPerson, String nomIndispo, String nomCours,String prenomPerson) {
        this.idPerson = idPerson;
        this.indispo_id = indispo_id;
        this.idCours = idCours;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nomPerson = nomPerson;
        this.nomIndispo = nomIndispo;
        this.nomCours = nomCours;
        this.prenomPerson= prenomPerson;
    }

    public PersonIndisponibiliteQueryDTO() {
    }

    public PersonIndisponibiliteQueryDTO(UUID idPerson, UUID indispo_id, UUID idCours, Date dateDebut, Date dateFin) {
        this.idPerson = idPerson;
        this.indispo_id = indispo_id;
        this.idCours = idCours;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public String getPrenomPerson() {
        return prenomPerson;
    }

    public void setPrenomPerson(String prenomPerson) {
        this.prenomPerson = prenomPerson;
    }

    public String getNomPerson() {
        return nomPerson;
    }

    public void setNomPerson(String nomPerson) {
        this.nomPerson = nomPerson;
    }

    public String getNomIndispo() {
        return nomIndispo;
    }

    public void setNomIndispo(String nomIndispo) {
        this.nomIndispo = nomIndispo;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public UUID getIndispo_id() {
        return indispo_id;
    }

    public void setIndispo_id(UUID indispo_id) {
        this.indispo_id = indispo_id;
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

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
