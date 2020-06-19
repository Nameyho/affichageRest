package com.affichageRest.affichageRest.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Role",schema = "public",catalog = "AffichageRest")
public class Role implements Serializable {

    @Id
    private UUID idRole;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String description;




    @OneToMany(mappedBy = "roles")
    private Set<Person> users;

    public Role() {
    }




    public Role(String name, String description) {
        this.name = name;
        this.description = description;
        this.idRole = UUID.nameUUIDFromBytes((name).getBytes())
;
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

    public Set<Person> getUsers() {
        return users;
    }

    public void setUsers(Set<Person> users) {
        this.users = users;
    }
}

