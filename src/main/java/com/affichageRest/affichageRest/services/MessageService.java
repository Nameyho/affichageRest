package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DTO.MessageQueryDTO;

import java.util.List;
import java.util.UUID;

public interface MessageService {

    List<MessageQueryDTO> getAllMessages();

    MessageQueryDTO getMessage(UUID id);

    UUID createMessage(MessageQueryDTO messages);

    void updateMessages(UUID id, MessageQueryDTO messages);

    void delete(UUID id);

}
