package com.affichageRest.affichageRest;

import com.affichageRest.affichageRest.DAO.*;
import com.affichageRest.affichageRest.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class DataLoader implements ApplicationRunner {


    private RoleRepository roleRepository;

    private UserRepository userRepository;

    private CoursRepository coursRepository;

    private IndisponibiliteRepository indisponibiliteRepository;

    private MessageRepository messageRepository ;

    private PersonRepository personRepository;

    @Autowired
    public DataLoader(RoleRepository roleRepository, UserRepository userRepository,
                      CoursRepository coursRepository, IndisponibiliteRepository indisponibiliteRepository,
                      MessageRepository messageRepository, PersonRepository personRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.coursRepository = coursRepository;
        this.indisponibiliteRepository = indisponibiliteRepository;
        this.messageRepository = messageRepository;
        this.personRepository = personRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        UUID idRole = UUID.randomUUID();
        UUID idUser = UUID.randomUUID();

        Role role = new Role(idRole,"Administrateur","Accés total");

        roleRepository.save(role);

        userRepository.save(new User(idUser,"Florence",
                "$2a$10$QuxwP8qhB7iX0nWf8KKHLu38zte43nN6cNO2IP4ZBYAkO4slr.iyK",role));


        /** $2a$10$QuxwP8qhB7iX0nWf8KKHLu38zte43nN6cNO2IP4ZBYAkO4slr.iyK  = test **/


        coursRepository.save(new Cours(UUID.randomUUID(),
                "Programmation Orientée Objet"));

        indisponibiliteRepository.save(new Indisponibilite(UUID.randomUUID(),"Maladie"));

        Date date = null ;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = simpleDateFormat.parse("01/10/1993");

        Person person =new Person(UUID.randomUUID(),"Mathieu","Allard","allardmathieu@gmail.com",date);

        personRepository.save(person);

        date = simpleDateFormat.parse("01/10/2020");

        messageRepository.save(new Messages("Ceci est un message de test",date,person));
    }
}