package com.affichageRest.affichageRest.services;

import com.affichageRest.affichageRest.model.Person;

import java.util.Collection;

public interface PersonService {

    Collection<Person> getAllPerson();
    Person getPerson(Long id);
    Person save(Person person);
    Person updatePerson(Long id,Person person);
    void delete(Long id);

}
