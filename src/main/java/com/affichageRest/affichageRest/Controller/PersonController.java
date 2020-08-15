package com.affichageRest.affichageRest.Controller;

import com.affichageRest.affichageRest.DAO.RoleRepository;
import com.affichageRest.affichageRest.DTO.PersonQueryDTO;
import com.affichageRest.affichageRest.model.Role;
import com.affichageRest.affichageRest.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private RoleRepository roleRepository;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<PersonQueryDTO>> getAllPersons() {
        return new ResponseEntity<>(personService.getAllPerson(), HttpStatus.OK);

    }

    @GetMapping(value = "/roles/{id}")
    public ResponseEntity<PersonQueryDTO> getPersonByRoles(@PathVariable(value = "id") UUID id) {
        Role role = roleRepository.findById(id).get();
        return new ResponseEntity(personService.findAllByRoles(role), HttpStatus.OK);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonQueryDTO> getPerson(@PathVariable(value = "id") UUID id) {
        return new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK);

    }

    @GetMapping(value = "/n/{id}")
    public ResponseEntity<PersonQueryDTO> getPersonNumeroUnique(@PathVariable int id) {
        return new ResponseEntity(personService.findByNumerounique(id), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<UUID> createPerson(@RequestBody PersonQueryDTO person) {

        return new ResponseEntity<>(personService.createPerson(person), HttpStatus.CREATED);
    }


    @PutMapping(value = "/{id}")
    public void updatePerson(@PathVariable(value = "id") UUID id,
                             @RequestBody PersonQueryDTO personUpdateDTO) {
        personService.updatePerson(id, personUpdateDTO);
    }



    @DeleteMapping(value = "/{id}")
    public void deletePerson(@PathVariable(value = "id") UUID id) {
        personService.delete(id);

    }
}
