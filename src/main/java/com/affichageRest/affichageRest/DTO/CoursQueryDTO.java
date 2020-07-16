package com.affichageRest.affichageRest.DTO;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

public class CoursQueryDTO {

    private UUID idCours;

    @NotNull
    private String name;

    private Date datedebut;
    private Date datefin;


    public CoursQueryDTO() {
    }

    public CoursQueryDTO(UUID idRole, String name) {
        this.idCours = idRole;
        this.name = name;

    }

    public CoursQueryDTO(UUID idCours, @NotNull String name, Date datedebut, Date datefin) {
        this.idCours = idCours;
        this.name = name;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    public UUID getIdCours() {
        return idCours;
    }

    public void setIdCours(UUID idCours) {
        this.idCours = idCours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }
}
