package com.affichageRest.affichageRest.model;


import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "Message",schema = "public",catalog = "AffichageRest")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column (name="MESSAGE_ID") private Long id;

    private String Contenu;
    private Date createdAt;
    private Date submitAt;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "PERSON_ID")
    private Person person;
}
