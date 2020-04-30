package com.affichageRest.affichageRest.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.UUID;

public class CoursCreateDTO {

    private UUID idRole;

    @NotNull
    private String name;



    public CoursCreateDTO() {
    }

    public CoursCreateDTO(UUID idRole, String name) {
        this.idRole = idRole;
        this.name = name;

    }

    public UUID getIdRole() {
        return idRole;
    }

    public void setIdRole(UUID idRole) {
        this.idRole = idRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
