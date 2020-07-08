package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.DAO.CoursRepository;
import com.affichageRest.affichageRest.DAO.PersonRepository;
import com.affichageRest.affichageRest.DAO.RoleRepository;
import com.affichageRest.affichageRest.DTO.PersonQueryDTO;
import com.affichageRest.affichageRest.model.Person;
import com.affichageRest.affichageRest.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service(value = "PersonService")
public class PersonServiceImplement implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CoursRepository coursRepository;

    @Override
    public List<PersonQueryDTO> getAllPerson() {

        List<PersonQueryDTO> plist = new ArrayList<>();
        personRepository.findAll().forEach(person -> {
            String nomrole = roleRepository.findById(person.getRoles().getId()).get().getName();
            plist.add(new PersonQueryDTO(person.getIdPerson(), person.getPrenom(), person.getNom(), person.getEmail(), person.getDateAnniversaire(), person.getRoles().getIdRole(), nomrole));
        });
        return plist;
    }

    @Override
    public PersonQueryDTO getPerson(UUID id) {

        if (personRepository.findById(id).isPresent()) {
            Person persontemp = personRepository.findById(id).get();

            return new PersonQueryDTO(
                    persontemp.getIdPerson(),
                    persontemp.getPrenom(),
                    persontemp.getNom(),
                    persontemp.getEmail(),
                    persontemp.getDateAnniversaire(),
                    persontemp.getRoles().getIdRole(),
                    roleRepository.findById(persontemp.getRoles().getId()).get().getName()
            );
        } else {
            return null;
        }
    }

    @Override
    public List<PersonQueryDTO> findAllByRoles(Role role) {
        List<PersonQueryDTO> plist = new ArrayList<>();
        personRepository.findAllByRoles(role).forEach(person -> {
            plist.add(new PersonQueryDTO(person.getIdPerson(), person.getPrenom(), person.getNom(), person.getEmail(),
                    person.getDateAnniversaire(), role.getIdRole(), role.getName()));
        });
        return plist;
    }

    @Override
    public UUID createPerson(PersonQueryDTO person) {

        Person nouvPersonne = new Person();


        System.out.println(person.getDateAnniversaire());
        nouvPersonne.setDateAnniversaire(person.getDateAnniversaire());
        nouvPersonne.setEmail(person.getEmail());
        nouvPersonne.setNom(person.getNom());
        nouvPersonne.setPrenom(person.getPrenom());
        nouvPersonne.setRoles(roleRepository.findById(person.getIdRole()).get());

        nouvPersonne.setIdPerson(UUID.nameUUIDFromBytes((person.getPrenom() + person.getNom()
                + person.getEmail() + person.getDateAnniversaire()).getBytes()));

        return personRepository.save(nouvPersonne).getIdPerson();
    }

    @Override
    public void updatePerson(UUID id, PersonQueryDTO person) {

        if (personRepository.findById(id).isPresent()) {
            Person personneExistant = personRepository.findById(id).get();

            personneExistant.setDateAnniversaire(person.getDateAnniversaire());
            personneExistant.setEmail(person.getEmail());
            personneExistant.setNom(person.getNom());
            personneExistant.setPrenom(person.getPrenom());
            personneExistant.setRoles(roleRepository.findById(person.getIdRole()).get());

            personRepository.save(personneExistant);

        }

    }

    @Override
    public void delete(UUID id) {
        Person personne = this.personRepository.findById(id).get();
        this.personRepository.delete(personne);
    }


}
