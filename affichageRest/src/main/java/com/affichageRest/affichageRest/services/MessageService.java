package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DTO.MessageCreateDTO;
import com.affichageRest.affichageRest.DTO.MessageGetDTO;
import com.affichageRest.affichageRest.DTO.MessageUpdateDTO;

import java.util.List;
import java.util.UUID;

public interface MessageService {

    List<MessageGetDTO> getAllMessages();
    MessageGetDTO getMessage(UUID id);
    public UUID createMessage(MessageCreateDTO messages);
    void updateMessages(UUID id, MessageUpdateDTO messages);
    void delete(UUID id);

}
