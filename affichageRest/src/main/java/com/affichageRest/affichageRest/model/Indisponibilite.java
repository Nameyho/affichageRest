package com.affichageRest.affichageRest.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
public class Indisponibilite implements Serializable {


    @Id

    @Column(name = "INDISPO_ID") private UUID idinsponibilite;

    @NotNull
    private String type;

//    @OneToMany(mappedBy = "person")
//    private Set<CoursEnseigne> courEnseignes;

/*    @OneToMany(mappedBy = "person")
    private Set<PersonIndisponibilite> personIndisponibilites;*/

    public Indisponibilite(UUID id, Set<CoursEnseigne> courEnseignes, Set<PersonIndisponibilite> personIndisponibilites, String type) {
        this.idinsponibilite = id;

        //this.personIndisponibilites = personIndisponibilites;
        this.type = type;
    }

    public UUID getIdinsponibilite() {
        return idinsponibilite;
    }

    public void setIdinsponibilite(UUID idinsponibilite) {
        this.idinsponibilite = idinsponibilite;
    }

    public Indisponibilite() {
    }

    public Indisponibilite( @NotNull String type) {
        this.idinsponibilite = UUID.nameUUIDFromBytes(type.getBytes());
        this.type = type;
    }
    /*    public UUID getId() {
        return idinsponibilite;
    }

    public void setId(UUID id) {
        this.idinsponibilite = id;
    }*/

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
