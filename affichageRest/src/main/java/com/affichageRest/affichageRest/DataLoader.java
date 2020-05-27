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

    private PersonResultatRepository personResultatrep;

    private PersonIndisponibiliteRepository personIndisponibiliteRepository;

    @Autowired
    public DataLoader(RoleRepository roleRepository, UserRepository userRepository,
                      CoursRepository coursRepository, IndisponibiliteRepository indisponibiliteRepository,
                      MessageRepository messageRepository, PersonRepository personRepository,PersonResultatRepository personResultat,PersonIndisponibiliteRepository personIndisponibiliteRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.coursRepository = coursRepository;
        this.indisponibiliteRepository = indisponibiliteRepository;
        this.messageRepository = messageRepository;
        this.personRepository = personRepository;
        this.personResultatrep = personResultat;
        this.personIndisponibiliteRepository=personIndisponibiliteRepository;
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


        for (int i = 0; i < 50 ; i++) {




        Cours cours = new Cours(UUID.randomUUID(),
                "Programmation Orientée Objet");

        coursRepository.save(cours);

        Indisponibilite indisponibilite = new Indisponibilite(UUID.randomUUID(),"Maladie");

        indisponibiliteRepository.save(indisponibilite);

        Date date = null ;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = simpleDateFormat.parse("01/10/1993");

        Person person =new Person(UUID.randomUUID(),"Mathieu","Allard","allardmathieu@gmail.com",date);

        personRepository.save(person);

        date = simpleDateFormat.parse("01/10/2020");

        messageRepository.save(new Messages("Ceci est un message de test",date,person));

        PersonResultatPK personResultatPK = new PersonResultatPK(person.getIdPerson(),cours.getId());

        Date date2 = null ;

        date2 = simpleDateFormat.parse("01/10/2020");

        PersonResultat  personResultat = new PersonResultat(personResultatPK,date2,90,true);

        personResultatrep.save(personResultat);

        PersonIndisponibilitePK personIndisponibilitePK = new PersonIndisponibilitePK(person.getId(),indisponibilite.getIdinsponibilite(),cours.getId());

            Date datedeb = simpleDateFormat.parse("01/10/2020");

            Date datefin  = simpleDateFormat.parse("01/12/2020");

            System.out.println(person.getId());
            System.out.println(indisponibilite.getIdinsponibilite());
            System.out.println(cours.getId());
            System.out.println(datedeb);
            System.out.println(datefin);


        PersonIndisponibilite personIndisponibilite = new PersonIndisponibilite(personIndisponibilitePK,datedeb,datefin);
        personIndisponibiliteRepository.save(personIndisponibilite);
    }
}}
