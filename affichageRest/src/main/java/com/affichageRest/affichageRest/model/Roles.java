package com.affichageRest.affichageRest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Role",schema = "public",catalog = "AffichageRest")
public class Roles implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;


    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "PERSON_ID")
    private Person personnes;


    public Roles() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


}
