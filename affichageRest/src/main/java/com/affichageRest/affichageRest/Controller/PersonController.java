package com.affichageRest.affichageRest.Controller;

import com.affichageRest.affichageRest.model.Person;
import com.affichageRest.affichageRest.services.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {

    @Resource
    PersonService personService;


    @GetMapping
   public Collection getAllPerson(){
        return this.personService.getAllPerson();
    }



    @PostMapping(value="/create")
         Person CreatePerson(@RequestBody Person person){

        return this.personService.save(person);
    }
}
