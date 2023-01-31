package com.stage.wael.controllers;


import com.stage.wael.entities.Fournisseur;
import com.stage.wael.repositories.FournisseurRepository;
import com.stage.wael.services.IFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fournisseur")
@CrossOrigin("*")
public class FournisseurController {

    //Injection de dependances
    @Autowired
    IFournisseurService fournisseurService;
    @Autowired
    FournisseurRepository fournisseurRepository;

//*****************retrieve all*********************
    @GetMapping("/retrieve-all-fournisseurs")
    @ResponseBody
    public List<Fournisseur> retrieveAllFournisseurs(){

        return fournisseurService.retrieveAllFournisseur();
    }
//********************retrieve one fournisseur**************
    @GetMapping("/retrieveOneFournisseur/{id}")
    @ResponseBody
    public Serializable retrieveFournisseur(@PathVariable("id")Long id){
        return fournisseurService.retrieveFournisseur(id) != null ?fournisseurService.retrieveFournisseur(id):new ArrayList<Lookup>();
    }
    //***************add fournisseur*************************
    @PostMapping("/add-fournisseur")
    @ResponseBody
    public Fournisseur addFournisseur(@RequestBody Fournisseur f){

        return fournisseurService.addFournisseur(f);
    }

    //****************delete fournisseur**********************
    @DeleteMapping("/delete-fournisseur/{id}")
    public void deleteFournisseur(@PathVariable("id")Long id){

        fournisseurService.deleteFournisseur(id);
    }
    //***************update fournsseur************************
    @CrossOrigin
    @PostMapping(value = "/update-fournisseur/")
    @ResponseBody
    public Fournisseur updateFournisseur(@RequestBody Fournisseur f){

       return fournisseurService.updateFournisseur(f);
    }
}
