package com.affichageRest.affichageRest.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class CoursUpdateDTO {

    private UUID idRole;

    @NotNull
    @NotEmpty
    private String name;



    public CoursUpdateDTO() {
    }

    public CoursUpdateDTO(UUID idRole, String name) {
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
