package com.affichageRest.affichageRest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Role",schema = "public",catalog = "AffichageRest")
public class Roles implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idRole;

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

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public Long getId() {
        return idRole;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


}
