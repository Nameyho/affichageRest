package com.affichageRest.affichageRest.Controller;


import com.affichageRest.affichageRest.DTO.CoursQueryDTO;
import com.affichageRest.affichageRest.services.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@CrossOrigin
@RestController
@RequestMapping(value = "/cours")
public class CoursController {

    @Autowired
    private CoursService coursService;


    @GetMapping
    public ResponseEntity<List<CoursQueryDTO>> getAllCours() {
        return new ResponseEntity<>(coursService.getAllCours(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CoursQueryDTO> getAllCours(@PathVariable(value = "id") UUID id) {
        return new ResponseEntity<>(coursService.getCours(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<UUID> createCours(@RequestBody @Valid CoursQueryDTO role) {
        return new ResponseEntity<>(coursService.createCours(role), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public void updateCours(@PathVariable(value = "id") UUID id,
                            @RequestBody CoursQueryDTO coursUpdateDTO) {
        coursService.updateCours(id, coursUpdateDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCours(@PathVariable(value = "id") UUID id) {
        coursService.delete(id);

    }
}
