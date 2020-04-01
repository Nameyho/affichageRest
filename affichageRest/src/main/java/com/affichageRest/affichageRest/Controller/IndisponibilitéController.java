package com.affichageRest.affichageRest.Controller;

import com.affichageRest.affichageRest.model.Cours;
import com.affichageRest.affichageRest.model.Indisponibilite;
import com.affichageRest.affichageRest.services.CoursService;
import com.affichageRest.affichageRest.services.IndisponibiliteService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@RequestMapping(value = "/indisponibilites")
public class IndisponibilitéController {

    @Resource
    IndisponibiliteService indisponibiliteService;


    @GetMapping
   public Collection getAllCours(){
        return this.indisponibiliteService.getAllCours();
    }



    @PostMapping(value="/create")
         Indisponibilite Createindisponibilité(@RequestBody Indisponibilite indisponibilite){

        return this.indisponibiliteService.save(indisponibilite);
    }
}
