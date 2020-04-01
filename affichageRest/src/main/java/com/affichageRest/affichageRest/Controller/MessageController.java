package com.affichageRest.affichageRest.Controller;

import com.affichageRest.affichageRest.model.Cours;
import com.affichageRest.affichageRest.model.Messages;
import com.affichageRest.affichageRest.services.MessageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@RequestMapping(value = "/messages")
public class MessageController {

    @Resource
    MessageService messageService;


    @GetMapping
   public Collection getAllmessages(){
        return this.messageService.getAllCours();
    }



    @PostMapping(value="/create")
         Messages Createcours(@RequestBody Messages messages){

        return this.messageService.save(messages);
    }
}
