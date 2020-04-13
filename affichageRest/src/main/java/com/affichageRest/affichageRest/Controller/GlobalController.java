package com.affichageRest.affichageRest.Controller;


import com.affichageRest.affichageRest.DTO.CoursEnseigneCreateDTO;
import com.affichageRest.affichageRest.services.CoursEnseigneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.OnError;
import java.util.UUID;

@RestController
@RequestMapping(value = "/")
public class GlobalController {

    private CoursEnseigneService coursEnseigneService;


    @PostMapping(value = "/coursens/create")
    public HttpStatus create(@RequestBody CoursEnseigneCreateDTO coursEnseigneCreateDTO){
        if(coursEnseigneCreateDTO==null){
            coursEnseigneService.createCoursEnseigne(coursEnseigneCreateDTO);

            return HttpStatus.OK;
        }
        else{
            return HttpStatus.BAD_REQUEST;
        }
    }














}
