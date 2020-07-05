package com.affichageRest.affichageRest.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.UUID;

public class CoursQueryDTO {

    private UUID idCours;

    @NotNull
    private String name;



    public CoursQueryDTO() {
    }

    public CoursQueryDTO(UUID idRole, String name) {
        this.idCours = idRole;
        this.name = name;

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

}
