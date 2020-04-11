package com.affichageRest.affichageRest.model;




import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "Message",schema = "public",catalog = "AffichageRest")
public class Messages implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column (name="MESSAGE_ID") private UUID idMessage;

    private String Contenu;
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

    public UUID getId() {
        return idMessage;
    }

    public void setId(UUID id) {
        this.idMessage = id;
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

    public void setIdMessage(UUID idMessage) {
        this.idMessage = idMessage;
    }

    public void setContenu(String contenu) {
        Contenu = contenu;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
