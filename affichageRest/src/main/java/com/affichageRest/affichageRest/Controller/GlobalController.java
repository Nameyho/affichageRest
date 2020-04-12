package com.affichageRest.affichageRest.Controller;


import com.affichageRest.affichageRest.DTO.CoursEnseigneCreateDTO;
import com.affichageRest.affichageRest.services.CoursEnseigneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/")
public class GlobalController {

    private CoursEnseigneService coursEnseigneService;


    @PostMapping(value = "/error")
    public ResponseEntity<UUID> CreateError(){

        return new ResponseEntity<>( HttpStatus.UNAUTHORIZED);
    }

    @PostMapping(value = "/coursens/create")
    public void create(@RequestBody CoursEnseigneCreateDTO coursEnseigneCreateDTO){

        coursEnseigneService.createCoursEnseigne(coursEnseigneCreateDTO);
    }














}
