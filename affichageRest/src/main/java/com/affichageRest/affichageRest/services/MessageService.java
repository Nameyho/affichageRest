package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.model.Messages;

import java.util.Collection;

public interface MessageService {

    Collection<Messages> getAllCours();
    Messages getMessage(Long id);
    Messages save(Messages messages);
    Messages updateMessages(Long id, Messages messages);
    void delete(Long id);

}
