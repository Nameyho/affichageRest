package com.affichageRest.affichageRest.services;





import com.affichageRest.affichageRest.DAO.MessageRepository;
import com.affichageRest.affichageRest.model.Messages;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

@Service(value="MessagesService")
public class MessageServiceImplement implements MessageService {

    @Resource
    private MessageRepository messageRepository;
    @Override
    public Collection<Messages> getAllCours() {
        return (Collection<Messages>) messageRepository.findAll();
    }

    @Override
    public Messages getMessage(Long id) {
        return this.messageRepository.findById(id).get();
    }

    @Override
    public Messages save(Messages message) {
        return this.messageRepository.save(message);
    }

    @Override
    public Messages updateMessages(Long id, Messages message) {
        //mettre à jour plus tard
        return this.messageRepository.save(message);
    }

    @Override
    public void delete(Long id) {
        Messages messages = this.messageRepository.findById(id).get();
        this.messageRepository.delete(messages);
    }
}
