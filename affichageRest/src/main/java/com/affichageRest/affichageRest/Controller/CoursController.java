package com.affichageRest.affichageRest.Controller;

import com.affichageRest.affichageRest.model.Cours;
import com.affichageRest.affichageRest.services.CoursService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@RequestMapping(value = "/Cours")
public class CoursController {

    @Resource
    CoursService coursService;


    @GetMapping
   public Collection getAllCours(){
        return this.coursService.getAllCours();
    }



    @PostMapping(value="/create")
         Cours Createcours(@RequestBody Cours cours){

        return this.coursService.save(cours);
    }
}
