package com.affichageRest.affichageRest.Controller;

import com.affichageRest.affichageRest.DTO.*;
import com.affichageRest.affichageRest.model.Cours;
import com.affichageRest.affichageRest.model.Messages;
import com.affichageRest.affichageRest.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/messages")
public class MessageController {

    @Autowired
    MessageService messageService;


    @GetMapping(value = "/get")
   public ResponseEntity<List<MessageGetDTO>> getAllMessages(){
        return new ResponseEntity<>(messageService.getAllMessages(), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<MessageGetDTO> getPerson(@PathVariable(value="id") UUID id){
        return new ResponseEntity<>(messageService.getMessage(id),HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<UUID>createMessage(@RequestBody MessageCreateDTO person){

        return new ResponseEntity<>(messageService.createMessage(person), HttpStatus.CREATED);
    }


    @PutMapping(value="/update/{id}")
    public void updateMessage(@PathVariable(value="id") UUID id,
                             @RequestBody MessageUpdateDTO messageUpdateDTO){
        messageService.updateMessages(id,messageUpdateDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteMessage(@PathVariable(value = "id") UUID id){
        messageService.delete(id);

    }}
