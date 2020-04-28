package com.affichageRest.affichageRest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Role",schema = "public",catalog = "AffichageRest")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID idRole;

    private String name;
    private String description;


    @OneToMany
    private Set<User> users;

    public Role() {
    }

    public Role(String name, String description) {
        this.name = name;
        this.description = description;

    }

    public void setIdRole(UUID idRole) {
        this.idRole = idRole;
    }

    public UUID getId() {
        return idRole;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UUID getIdRole() {
        return idRole;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
