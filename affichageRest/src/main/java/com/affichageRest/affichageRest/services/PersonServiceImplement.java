package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.DAO.PersonRepository;
import com.affichageRest.affichageRest.DAO.RoleRepository;
import com.affichageRest.affichageRest.DTO.PersonCreateDTO;
import com.affichageRest.affichageRest.DTO.PersonGetDTO;
import com.affichageRest.affichageRest.DTO.PersonUpdateDTO;
import com.affichageRest.affichageRest.model.Person;
import com.affichageRest.affichageRest.model.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service(value="PersonService")
public class PersonServiceImplement implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<PersonGetDTO> getAllPerson() {

        List<PersonGetDTO> plist = new ArrayList<>();
        personRepository.findAll().forEach(person -> {
            plist.add(new PersonGetDTO(person.getId(),person.getPrenom(),person.getNom(),person.getEmail(),person.getDateAnniversaire(),person.getRole().getIdRole()));
        });
        return plist;
    }

    @Override
    public PersonGetDTO getPerson(UUID id) {

        if(personRepository.findById(id).isPresent()){
            Person persontemp = personRepository.findById(id).get();


            return new PersonGetDTO(persontemp.getId(),persontemp.getPrenom(),
                    persontemp.getNom(),persontemp.getEmail(),persontemp.getDateAnniversaire(),persontemp.getRole().getIdRole());
        }
    else{
        return null;
    }}

    @Override
    public UUID createPerson(PersonCreateDTO person) {

        Person nouvPersonne = new Person();

        nouvPersonne.setIdPerson(UUID.randomUUID());
        nouvPersonne.setDateAnniversaire(person.getDateAnniversaire());
        nouvPersonne.setEmail(person.getEmail());
        nouvPersonne.setNom(person.getNom());
        nouvPersonne.setPrenom(person.getPrenom());

       Roles role= roleRepository.findById(person.getIdRole()).get();


            nouvPersonne.setRole(role);


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
            Roles role= roleRepository.findById(person.getIdRole()).get();
            personneExistant.setRole(role);
            personRepository.save(personneExistant);

        }

    }

    @Override
    public void delete(UUID id) {
        Person personne = this.personRepository.findById(id).get();
        this.personRepository.delete(personne);
    }
}
