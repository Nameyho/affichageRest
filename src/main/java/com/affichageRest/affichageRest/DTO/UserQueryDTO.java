package com.affichageRest.affichageRest.DTO;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

public class UserQueryDTO {

    private UUID id;


    @NotEmpty(message = "Le nom ne dois pas être vide")
    private String username;

    private String password;


    public UserQueryDTO() {
    }

    public UserQueryDTO(UUID id, String username,String password) {
        this.id = id;
        this.username = username;
        this.password = password;

    }

    public UserQueryDTO(UUID id, @NotEmpty(message = "Le nom ne dois pas être vide") String username) {
        this.id = id;
        this.username = username;
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


}
