package com.affichageRest.affichageRest.DTO;

import java.util.UUID;

public class CoursGetDTO {

    private UUID idRole;
    private String name;


    public CoursGetDTO() {
    }

    public CoursGetDTO(UUID idRole, String name) {
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
