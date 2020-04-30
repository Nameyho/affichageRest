package com.affichageRest.affichageRest.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "User",schema = "public",catalog = "AffichageRest")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="USER_ID")
    private UUID idUser;

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;


    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "id_role")
    private Role roles;


    @OneToMany(mappedBy="user")
    private Set<Messages> messages;

    public User(UUID id) {
        this.idUser = id;
    }

    public User() {
    }

    public User(UUID id, String username, String password, Role roles) {
        this.idUser = id;
        this.username = username;
        this.password = password;

        this.roles = roles;
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


    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }
}