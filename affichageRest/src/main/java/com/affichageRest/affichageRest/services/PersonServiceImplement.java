package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.DAO.PersonRepository;
import com.affichageRest.affichageRest.DTO.PersonCreateDTO;
import com.affichageRest.affichageRest.DTO.PersonUpdateDTO;
import com.affichageRest.affichageRest.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.UUID;

@Service(value="PersonService")
public class PersonServiceImplement implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Override
    public Collection<Person> getAllPerson() {
        return (Collection<Person>) personRepository.findAll();
    }

    @Override
    public Person getPerson(UUID id) {
        return this.personRepository.findById(id).get();
    }

    @Override
    public UUID createPerson(PersonCreateDTO person) {

        Person nouvPersonne = new Person();

        nouvPersonne.setIdPerson(UUID.randomUUID());
        nouvPersonne.setDateAnniversaire(person.getDateAnniversaire());
        nouvPersonne.setEmail(person.getEmail());
        nouvPersonne.setNom(person.getNom());
        nouvPersonne.setPrenom(person.getPrenom());
       //nouvPersonne.setId_role(person.getRoles());

        return personRepository.save(nouvPersonne).getId();
    }

    @Override
    public void updatePerson(UUID id, PersonUpdateDTO person) {

        if(personRepository.findById(id).isPresent()) {
            Person personneExistant = personRepository.findById(id).get();

            personneExistant.setDateAnniversaire(person.getDateAnniversaire());
            personneExistant.setEmail(person.getEmail());
            personneExistant.setNom(person.getNom());
            personneExistant.setPrenom(person.getPrenom());
            //personneExistant.setRolesID(person.getIdRoles());

            personRepository.save(personneExistant);

        }

    }

    @Override
    public void delete(UUID id) {
        Person personne = this.personRepository.findById(id).get();
        this.personRepository.delete(personne);
    }
}
