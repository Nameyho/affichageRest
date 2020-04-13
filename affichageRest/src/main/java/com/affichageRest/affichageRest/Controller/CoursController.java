package com.affichageRest.affichageRest.Controller;


import com.affichageRest.affichageRest.DTO.CoursCreateDTO;
import com.affichageRest.affichageRest.DTO.CoursGetDTO;
import com.affichageRest.affichageRest.DTO.CoursUpdateDTO;
import com.affichageRest.affichageRest.services.CoursService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;



    @RestController
    @RequestMapping(value = "/cours")
    public class CoursController {

        @Autowired
        private CoursService coursService;


        @GetMapping(value="/get")
        public ResponseEntity<List<CoursGetDTO>> getAllCours(){
            return new ResponseEntity<>(coursService.getAllCours(), HttpStatus.OK);
        }

        @GetMapping(value="/get/{id}")
        public ResponseEntity<CoursGetDTO> getAllCours(@PathVariable(value="id") UUID id){
            return new ResponseEntity<>(coursService.getCours(id), HttpStatus.OK);
        }


        @PostMapping(value="/create")
        public ResponseEntity<UUID> createRole(@RequestBody CoursCreateDTO role){

            return new ResponseEntity<>(coursService.createCours(role),HttpStatus.CREATED);
        }

        @PutMapping(value="/update/{id}")
        public void updateRole(@PathVariable(value="id") UUID id,
                               @RequestBody CoursUpdateDTO coursUpdateDTO){
            coursService.updateCours(id,coursUpdateDTO);
        }

        @DeleteMapping(value = "/delete/{id}")
        public void deleteRole(@PathVariable(value = "id") UUID id){
            coursService.delete(id);

        }
}
