package com.affichageRest.affichageRest.model;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "User",schema = "public",catalog = "AffichageRest")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="USER_ID")
    private UUID id;

    private String username;

    private String password;

    @Transient
    private String passwordConfirm;

    @ManyToOne
    @JoinColumn(name = "idRole")
    private Role roles;

    @OneToMany(mappedBy="user")
    private Set<Messages> messages;

    public User(UUID id) {
        this.id = id;
    }

    public User() {
    }

    public User(UUID id, String username, String password, String passwordConfirm, Role roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.roles = roles;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }
}