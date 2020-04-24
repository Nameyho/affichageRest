package com.affichageRest.affichageRest.Controller;


import com.affichageRest.affichageRest.DTO.CoursEnseigneCreateDTO;
import com.affichageRest.affichageRest.DTO.CoursEnseigneGetDTO;
import com.affichageRest.affichageRest.services.CoursEnseigneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/")
public class GlobalController {

    @Autowired
    private CoursEnseigneService coursEnseigneService;


    @PostMapping(value = "/coursens/")
    public HttpStatus create(@RequestBody CoursEnseigneCreateDTO coursEnseigneCreateDTO){



            coursEnseigneService.createCoursEnseigne(coursEnseigneCreateDTO);

            return HttpStatus.OK;

    }

    @GetMapping(value = "/coursens/")
    public ResponseEntity<List<CoursEnseigneGetDTO>> getAllCours(){
        System.out.println("1" + coursEnseigneService);
        return new ResponseEntity<>(coursEnseigneService.getAllCoursEnseignes(), HttpStatus.OK);
    }














}
