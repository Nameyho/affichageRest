package com.affichageRest.affichageRest.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Role", schema = "public", catalog = "AffichageRest")
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

    public UUID getId() {
        return idRole;
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

    public UUID getIdRole() {
        return idRole;
    }

    public void setIdRole(UUID idRole) {
        this.idRole = idRole;
    }

    public Set<Person> getUsers() {
        return users;
    }

    public void setUsers(Set<Person> users) {
        this.users = users;
    }
}

