package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.DAO.PersonRepository;
import com.affichageRest.affichageRest.model.Person;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

@Service(value="PersonService")
public class PersonServiceImplement implements PersonService {

    @Resource
    private PersonRepository personRepository;
    @Override
    public Collection<Person> getAllPerson() {
        return (Collection<Person>) personRepository.findAll();
    }

    @Override
    public Person getPerson(Long id) {
        return this.personRepository.findById(id).get();
    }

    @Override
    public Person save(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public Person updatePerson(Long id, Person person) {
        //mettre à jour plus tard
        return this.personRepository.save(person);
    }

    @Override
    public void delete(Long id) {
        Person personne = this.personRepository.findById(id).get();
        this.personRepository.delete(personne);
    }
}
