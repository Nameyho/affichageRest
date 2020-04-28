package com.affichageRest.affichageRest.DTO;

import java.util.UUID;

public class UserCreateDTO {

    private UUID idUser;

    private String username;

    private String password;

    private UUID idRole;

    public UserCreateDTO() {
    }

    public UserCreateDTO(UUID id, String username, String password, UUID idRole) {
        this.idUser = id;
        this.username = username;
        this.password = password;
        this.idRole = idRole;
    }

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID id) {
        this.idUser = id;
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
