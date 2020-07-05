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

    private  CoursEnseigneRepository coursEnseigneRepository;

    @Autowired
    public DataLoader(RoleRepository roleRepository, UserRepository userRepository,
                      CoursRepository coursRepository, IndisponibiliteRepository indisponibiliteRepository,
                      MessageRepository messageRepository, PersonRepository personRepository,
                      PersonResultatRepository personResultat,
                      PersonIndisponibiliteRepository personIndisponibiliteRepository,
                      CoursEnseigneRepository coursEnseigneRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.coursRepository = coursRepository;
        this.indisponibiliteRepository = indisponibiliteRepository;
        this.messageRepository = messageRepository;
        this.personRepository = personRepository;
        this.personResultatrep = personResultat;
        this.personIndisponibiliteRepository=personIndisponibiliteRepository;
        this.coursEnseigneRepository=coursEnseigneRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {



        Role role = new Role("Eleves","Accés interdit");

        roleRepository.save(role);


        User user = new User("Florence",
                "$2a$10$QuxwP8qhB7iX0nWf8KKHLu38zte43nN6cNO2IP4ZBYAkO4slr.iyK");
        userRepository.save(user);


        /** $2a$10$QuxwP8qhB7iX0nWf8KKHLu38zte43nN6cNO2IP4ZBYAkO4slr.iyK  = test **/






        Cours cours = new Cours("Programmation Orientée Objet");

        coursRepository.save(cours);



        Indisponibilite indisponibilite = new Indisponibilite("Maladie");

        indisponibiliteRepository.save(indisponibilite);

        Date date = null ;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = simpleDateFormat.parse("01/10/1993");

        Person person =new Person("Mathieu","Allard","allardmathieu@gmail.com",date,role);

        personRepository.save(person);

        role = new Role("Professeur","accés restreint");

        roleRepository.save(role);

         person =new Person("Mat","All","allardmathieu@gmail.com",date,role);

        personRepository.save(person);

        date = simpleDateFormat.parse("01/10/2020");

        messageRepository.save(new Messages("Ceci est un message de test",date,user,"Message de Test"));


        System.out.println(person.getIdPerson());
        PersonResultatPK personResultatPK = new PersonResultatPK(person.getIdPerson(),cours.getId());

        Date date2 = null ;

        date2 = simpleDateFormat.parse("01/10/2020");

        PersonResultat  personResultat = new PersonResultat(personResultatPK,date2,90,true);

        personResultatrep.save(personResultat);


        PersonIndisponibilitePK personIndisponibilitePK = new PersonIndisponibilitePK(person.getIdPerson(),indisponibilite.getIdinsponibilite(),UUID.randomUUID());

            Date datedeb = simpleDateFormat.parse("01/10/2018");

            Date datefin  = simpleDateFormat.parse("01/12/2020");


        PersonIndisponibilite personIndisponibilite = new PersonIndisponibilite(personIndisponibilitePK,datedeb,datefin);
        personIndisponibiliteRepository.save(personIndisponibilite);

        CoursEnseigneID coursEnseigneID = new CoursEnseigneID(person.getIdPerson(),cours.getId());

        CoursEnseigne coursEnseigne = new CoursEnseigne(coursEnseigneID,datedeb,datefin);

        coursEnseigneRepository.save(coursEnseigne);



}}
