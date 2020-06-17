package com.affichageRest.affichageRest.DTO;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

public class UserQueryDTO {

    private UUID id;


    @NotEmpty(message = "Le nom ne dois pas être vide")
    private String username;

    private String password;

    private UUID idRole;

    public UserQueryDTO() {
    }

    public UserQueryDTO(UUID id, String username, String password, UUID idRole) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.idRole = idRole;
    }



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getIdRole() {
        return idRole;
    }

    public void setIdRole(UUID idRole) {
        this.idRole = idRole;
    }
}
