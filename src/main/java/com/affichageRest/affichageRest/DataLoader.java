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


    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    private final CoursRepository coursRepository;

    private final IndisponibiliteRepository indisponibiliteRepository;

    private final MessageRepository messageRepository;

    private final PersonRepository personRepository;

    private final PersonResultatRepository personResultatrep;

    private final PersonIndisponibiliteRepository personIndisponibiliteRepository;

    private final CoursEnseigneRepository coursEnseigneRepository;

    private final EcranRepository ecranRepository;

    private final EcranAbsenceRepository ecranAbsenceRepository;

    private final EcranResultatRepository ecranResultatRepository;

    private final EcranMessageRepository ecranMessageRepository;


    @Autowired
    public DataLoader(RoleRepository roleRepository, UserRepository userRepository,
                      CoursRepository coursRepository, IndisponibiliteRepository indisponibiliteRepository,
                      MessageRepository messageRepository, PersonRepository personRepository,
                      PersonResultatRepository personResultat,
                      PersonIndisponibiliteRepository personIndisponibiliteRepository,
                      CoursEnseigneRepository coursEnseigneRepository,
                      EcranRepository ecranRepository,
                      EcranAbsenceRepository ecranAbsenceRepository,
                      EcranResultatRepository ecranResultatRepository,
                      EcranMessageRepository ecranMessageRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.coursRepository = coursRepository;
        this.indisponibiliteRepository = indisponibiliteRepository;
        this.messageRepository = messageRepository;
        this.personRepository = personRepository;
        this.personResultatrep = personResultat;
        this.personIndisponibiliteRepository = personIndisponibiliteRepository;
        this.coursEnseigneRepository = coursEnseigneRepository;
        this.ecranRepository = ecranRepository;
        this.ecranAbsenceRepository = ecranAbsenceRepository;
        this.ecranResultatRepository = ecranResultatRepository;
        this.ecranMessageRepository = ecranMessageRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


        Role role = new Role("Eleves", "Accés interdit");

        roleRepository.save(role);


        User user = new User("Florence",
                "$2a$10$QuxwP8qhB7iX0nWf8KKHLu38zte43nN6cNO2IP4ZBYAkO4slr.iyK");
        userRepository.save(user);


        /** $2a$10$QuxwP8qhB7iX0nWf8KKHLu38zte43nN6cNO2IP4ZBYAkO4slr.iyK  = test **/


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date datedebut = simpleDateFormat.parse("01/10/2021");

        Date datefin = simpleDateFormat.parse("01/10/2022");


        Cours cours = new Cours("Programmation Orientée Objet", datedebut, datefin);

        coursRepository.save(cours);


        Indisponibilite indisponibilite = new Indisponibilite("Maladie");

        indisponibiliteRepository.save(indisponibilite);

        Date date = null;
        date = simpleDateFormat.parse("01/10/1993");

        Person person = new Person("Mathieu", "Allard", "allardmathieu@gmail.com", date, role);

        int numero;
        do {
            numero = (int)((Math.random()*10000000)+1000000000);
        }while (!(personRepository.findByNumerounique(numero).isEmpty()));

        person.setNumerounique(numero);
        personRepository.save(person);

        role = new Role("Professeur", "accés restreint");

        roleRepository.save(role);

        person = new Person("Mat", "All", "allardmathieu@gmail.com", date, role);

        do {
            numero = (int)((Math.random()*10000000)+1000000000);
        }while (!(personRepository.findByNumerounique(numero).isEmpty()));

        person.setNumerounique(numero);

        personRepository.save(person);

        date = simpleDateFormat.parse("01/10/2020");

        Messages message = new Messages("Ceci est un message de test", date, user, "Message de Test");

        messageRepository.save(message);


        System.out.println(person.getIdPerson());
        PersonResultatPK personResultatPK = new PersonResultatPK(person.getIdPerson(), cours.getId());

        Date date2 = null;

        date2 = simpleDateFormat.parse("01/10/2020");

        PersonResultat personResultat = new PersonResultat(personResultatPK, 90, true);

        personResultatrep.save(personResultat);


        PersonIndisponibilitePK personIndisponibilitePK = new PersonIndisponibilitePK(person.getIdPerson(), indisponibilite.getIdinsponibilite(), UUID.randomUUID());

        Date datedeb = simpleDateFormat.parse("01/10/2018");

        Date datefi = simpleDateFormat.parse("01/12/2020");


        PersonIndisponibilite personIndisponibilite = new PersonIndisponibilite(personIndisponibilitePK, datedeb, datefi);
        personIndisponibiliteRepository.save(personIndisponibilite);

        CoursEnseigneID coursEnseigneID = new CoursEnseigneID(person.getIdPerson(), cours.getId());

        CoursEnseigne coursEnseigne = new CoursEnseigne(coursEnseigneID, datedeb, datefin);

        coursEnseigneRepository.save(coursEnseigne);

        Ecran ecran = new Ecran("accueil");

        ecranRepository.save(ecran);


        EcranAbsenceID ecranAbsenceID = new EcranAbsenceID(ecran.getIdEcran(), personIndisponibilitePK);


        EcranAbsence ecranAbsence = new EcranAbsence(ecranAbsenceID);

        ecranAbsenceRepository.save(ecranAbsence);

        EcranResultatID ecranResultatID = new EcranResultatID(ecran.getIdEcran(), cours.getId());

        EcranResultat ecranResultat = new EcranResultat(ecranResultatID);

        ecranResultatRepository.save(ecranResultat);

        EcranMessageID ecranMessageID = new EcranMessageID(ecran.getIdEcran(),message.getIdMessage());

        EcranMessage ecranMessage = new EcranMessage(ecranMessageID);

        ecranMessageRepository.save(ecranMessage);
    }
}
