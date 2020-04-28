package com.affichageRest.affichageRest.services;





import com.affichageRest.affichageRest.DAO.MessageRepository;
import com.affichageRest.affichageRest.DAO.PersonRepository;
import com.affichageRest.affichageRest.DAO.UserRepository;
import com.affichageRest.affichageRest.DTO.MessageCreateDTO;
import com.affichageRest.affichageRest.DTO.MessageGetDTO;
import com.affichageRest.affichageRest.DTO.MessageUpdateDTO;
import com.affichageRest.affichageRest.model.Messages;
import com.affichageRest.affichageRest.model.Person;
import com.affichageRest.affichageRest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service(value="MessagesService")
public class MessageServiceImplement implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<MessageGetDTO> getAllMessages() {
        List<MessageGetDTO> plist = new ArrayList<>();
        messageRepository.findAll().forEach(message -> {
            plist.add(new MessageGetDTO(
                    message.getId(),
                    message.getContenu(),
                    message.getCreatedDate(),
                    message.getUser().getId()

                   ));
        });
        return plist;
    }

    @Override
    public MessageGetDTO getMessage(UUID id) {
        if(messageRepository.findById(id).isPresent()){
       Messages message = messageRepository.findById(id).get();

       return  new MessageGetDTO(message.getId(),message.getContenu(),message.getCreatedDate(),message.getUser().getId());
    }
    else{
        return null;
    }}

    @Override
    public UUID createMessage(MessageCreateDTO message) {

        Messages nouvMessage = new Messages();

        nouvMessage.setId(UUID.randomUUID());
        nouvMessage.setContenu(message.getContenu());
        nouvMessage.setCreatedDate(message.getCreatedDate());

        User person = userRepository.findById(message.getIdPerson()).get();

        nouvMessage.setUser(person);

        return messageRepository.save(nouvMessage).getId();}

    @Override
    public void updateMessages(UUID id, MessageUpdateDTO message) {
        if(messageRepository.findById(id).isPresent()) {

            Messages messagesExistant = messageRepository.findById(id).get();

            messagesExistant.setCreatedDate(message.createdDate);
            messagesExistant.setContenu(message.contenu);

            User person = userRepository.findById(message.getIdPerson()).get();

            messagesExistant.setUser(person);

            messageRepository.save(messagesExistant);
        }

    }

    @Override
    public void delete(UUID id) {
        Messages messages = this.messageRepository.findById(id).get();
        this.messageRepository.delete(messages);
    }
}
