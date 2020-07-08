package com.affichageRest.affichageRest.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Message", schema = "public", catalog = "AffichageRest")
public class Messages implements Serializable {

    @Id
    @Column(name = "MESSAGE_ID")
    private UUID idMessage;

    @NotNull
    private String Contenu;

    private Date createdDate;

    private String titreMessage;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Messages() {
    }

    public Messages(String contenu, Date createdDate, User user, String titreMessage) {
        Contenu = contenu;
        this.createdDate = createdDate;
        this.user = user;
        this.titreMessage = titreMessage;
        this.idMessage = UUID.nameUUIDFromBytes((contenu + createdDate.toString() + user.toString()).getBytes());


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

    public void setContenu(String contenu) {
        Contenu = contenu;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getTitreMessage() {
        return titreMessage;
    }

    public void setTitreMessage(String titreMessage) {
        this.titreMessage = titreMessage;
    }

    public UUID getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(UUID idMessage) {
        this.idMessage = idMessage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
