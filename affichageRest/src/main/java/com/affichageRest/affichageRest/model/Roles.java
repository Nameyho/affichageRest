package com.affichageRest.affichageRest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Role",schema = "public",catalog = "AffichageRest")
public class Roles implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID idRole;

    private String name;
    private String description;


    @OneToMany(mappedBy = "role")
    private Set<Person> personnes;

    public Roles() {
    }

    public Roles(String name, String description) {
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

    public Set<Person> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(Set<Person> personnes) {
        this.personnes = personnes;
    }
}
