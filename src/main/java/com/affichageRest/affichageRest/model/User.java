package com.affichageRest.affichageRest.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "User", schema = "public", catalog = "AffichageRest")
public class User {
    @Id
    @Column(name = "USER_ID")
    private UUID idUser;

    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String username;

    @NotNull
    @NotEmpty
    private String password;


    @OneToMany(mappedBy = "user")
    private Set<Messages> messages;

    public User(UUID id) {
        this.idUser = id;
    }

    public User() {
    }

    public User(String username, String password) {
        this.idUser = UUID.nameUUIDFromBytes((username + password).getBytes());
        this.username = username;
        this.password = password;


    }

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public Set<Messages> getMessages() {
        return messages;
    }

    public void setMessages(Set<Messages> messages) {
        this.messages = messages;
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
