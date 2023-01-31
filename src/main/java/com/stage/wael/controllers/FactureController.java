package com.stage.wael.controllers;

import com.stage.wael.entities.Facture;
import com.stage.wael.repositories.FactureRepository;
import com.stage.wael.services.IFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(maxAge = 3600, allowCredentials = "true",origins = "http://localhost:4200")
@RestController
@RequestMapping("/facture")
public class FactureController {
    @Autowired
    IFactureService iFactureService;
    @Autowired
    FactureRepository factureRepository;

    //********************add facture**********
    @PostMapping("/add-facture/{idClient}/{idFournisseur}")
    @ResponseBody
    public Facture addFacture(@RequestBody Facture af ,@PathVariable("idClient") Long idClient,@PathVariable("idFournisseur")Long
                               idFournisseur){

        return iFactureService.addFacture(af,idClient,idFournisseur);
    }

    //$$$$$$$$$$$$$$$$$retrieve-all
    @GetMapping("/fetch-factures")
    @ResponseBody
    public List<Facture> fetchFactures(){
        return iFactureService.retrieveAllFactures();
    }
    //*****************assign facture*************
    @PutMapping(value = "/assignFacture/{id}/{idC}/{idF}")
    @ResponseBody
    public void assignFacture(@PathVariable("id")Long id,@PathVariable("idC")Long idC,@PathVariable("idF")Long idF){

            iFactureService.assignFactureToClientAndFournisseur(id,idF,idC);
    }
   //******** delete facture
    @DeleteMapping("/delete-facture/{idF}")
    public Facture deleteFacture(@PathVariable("idF")Long idF){
        return iFactureService.cancelFacture(idF);
    }

    @CrossOrigin
    @PutMapping("/updateFacture/")
    @ResponseBody

    public Facture updateFacture(@RequestBody Facture f){

        return iFactureService.updateFacture(f);

    }
    //get client id par facture
    @GetMapping("/getClientId/{idFacture}")
    @ResponseBody
    public Long getClientId(@PathVariable("idFacture")Long id){
        return iFactureService.getIdClientByFacture(id);
    }
}
