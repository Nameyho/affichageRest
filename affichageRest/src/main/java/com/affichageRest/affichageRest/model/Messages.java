package com.affichageRest.affichageRest.model;


import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "Message",schema = "public",catalog = "AffichageRest")
public class Messages implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column (name="MESSAGE_ID") private Long id;

    private String Contenu;
    @CreatedDate
    private Date createdDate;


    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    public Messages() {
    }

    public Messages(String contenu, Date createdDate, Person person) {
        Contenu = contenu;
        this.createdDate = createdDate;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public String getContenu() {
        return Contenu;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Person getPerson() {
        return person;
    }
}
