package com.affichageRest.affichageRest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Role",schema = "public",catalog = "AffichageRest")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy="role")
    private Set<Person> Persons;

}
