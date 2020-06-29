package com.affichageRest.affichageRest.services;


import com.affichageRest.affichageRest.DAO.MessageRepository;
import com.affichageRest.affichageRest.DAO.UserRepository;
import com.affichageRest.affichageRest.DTO.MessageQueryDTO;
import com.affichageRest.affichageRest.model.Messages;
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
    public List<MessageQueryDTO> getAllMessages() {
        List<MessageQueryDTO> plist = new ArrayList<>();
        messageRepository.findAll().forEach(message -> {
            String nomUser = userRepository.findById(message.getUser().getIdUser()).get().getUsername();
            plist.add(new MessageQueryDTO(
                    message.getId(),
                    message.getContenu(),
                    message.getCreatedDate(),
                    message.getUser().getIdUser(),
                    nomUser,
                    message.getTitreMessage()


                   ));
        });
        return plist;
    }

    @Override
    public MessageQueryDTO getMessage(UUID id) {
        if(messageRepository.findById(id).isPresent()){
       Messages message = messageRepository.findById(id).get();
            String nomUser = userRepository.findById(message.getUser().getIdUser()).get().getUsername();
       return  new MessageQueryDTO(message.getId(),message.getContenu(),message.getCreatedDate(),  message.getUser().getIdUser(),nomUser,message.getTitreMessage());
    }
    else{
        return null;
    }}

    @Override
    public UUID createMessage(MessageQueryDTO message) {

        Messages nouvMessage = new Messages();

        nouvMessage.setId(UUID.nameUUIDFromBytes((message.contenu + message.createdDate +
                message.getNomPerson() + message.getTitreMessage()).getBytes()));
        nouvMessage.setContenu(message.getContenu());
        nouvMessage.setCreatedDate(message.getCreatedDate());
        nouvMessage.setTitreMessage(message.getTitreMessage());

        User person =userRepository.findByUsername(message.getNomPerson());

        nouvMessage.setUser(person);
        System.out.println(person.getIdUser());
        return messageRepository.save(nouvMessage).getId();}

    @Override
    public void updateMessages(UUID id, MessageQueryDTO message) {
        if(messageRepository.findById(id).isPresent()) {

            Messages messagesExistant = messageRepository.findById(id).get();

            messagesExistant.setCreatedDate(message.createdDate);
            messagesExistant.setContenu(message.contenu);
            messagesExistant.setTitreMessage(message.getTitreMessage());
            User person = userRepository.findByUsername(message.getNomPerson());

            messagesExistant.setUser(person);

            messageRepository.save(messagesExistant);
        }

    }

    @Override
    public void delete(UUID id) {
        System.out.println(id);
        Messages messages = this.messageRepository.findById(id).get();
        this.messageRepository.delete(messages);
    }
}
