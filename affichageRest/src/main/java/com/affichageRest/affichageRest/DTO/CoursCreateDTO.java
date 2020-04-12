package com.affichageRest.affichageRest.DTO;

import java.util.UUID;

public class CoursCreateDTO {

    private UUID idRole;
    private String name;
    private String description;


    public CoursCreateDTO() {
    }

    public CoursCreateDTO(UUID idRole, String name, String description) {
        this.idRole = idRole;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
