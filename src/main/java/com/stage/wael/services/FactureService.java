package com.stage.wael.services;

import com.stage.wael.entities.Client;
import com.stage.wael.entities.Facture;
import com.stage.wael.entities.Fournisseur;
import com.stage.wael.repositories.ClientRepository;
import com.stage.wael.repositories.FactureRepository;
import com.stage.wael.repositories.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class FactureService  implements IFactureService{

    @Autowired
    FactureRepository factureRepo;
    @Autowired
    FournisseurRepository fournisseurRepo;
    @Autowired
    ClientRepository clientRepo;

    @Autowired
    FournisseurRepository fourRepo;

    @Override
    public List<Facture> retrieveAllFactures() {

        return (List<Facture>) factureRepo.findAll();
    }

    @Override
    public Facture retrieveFacture(Long id) {
        return factureRepo.findById(id).orElse(null);
    }

    @Override
    public Facture cancelFacture(Long id) {
        Facture f = factureRepo.findById(id).orElse(null);
        factureRepo.deleteById(id);
        return f;

    }

    @Override
    public List<Facture> getFacturesByFournisseur(Long idF) {

        Fournisseur f1 = fournisseurRepo.findById(idF).orElse(null);


       return (List<Facture>) f1.getFactures();
    }

    @Override
    public List<Facture> getFacturesByClient(Long idC) {

        Client c1 = clientRepo.findById(idC).orElse(null);

        return (List<Facture>) c1.getFactures();
    }

    @Override
    public void assignFactureToClientAndFournisseur(Long id, Long idFour, Long idC) {


        Facture f1 = factureRepo.findById(id).orElse(null);
        Client c1= clientRepo.findById(idC).orElse(null);
        Fournisseur F1= fournisseurRepo.findById(idFour).orElse(null);


        assert c1 != null;
        c1.getFactures().add(f1);
        clientRepo.save(c1);

        assert F1 != null;
        F1.getFactures().add(f1);
        fournisseurRepo.save(F1);

    }

    @Override
    public Facture addFacture(Facture f,Long idClient,Long idFournisseur) {
        Client c1= clientRepo.findById(idClient).orElse(null);
        f.setClient(c1);

        Fournisseur f1 = fourRepo.findById(idFournisseur).orElse(null);
        f.setFournisseur(f1);
        return factureRepo.save(f);
    }

    @Override
    public Facture updateFacture(@NotNull Facture f) {
       // Facture f1 = factureRepo.findById(f.getIdFacture()).orElse(null);
        //f.setClient(f.getClient());
      //  Client c1= clientRepo.findById(f.getClient().getIdClient()).orElse(null);
        //f.setClient(c1);
        return  factureRepo.save(f);
    }

    @Override
    public Long getIdClientByFacture(Long idFacture) {

            Facture f = factureRepo.findById(idFacture).orElse(null);
            if(f ==null){
                long LOWER_RANGE = 100000; //assign lower range value
                long UPPER_RANGE = 1000000; //assign upper range value
                Random random = new Random();


                return LOWER_RANGE +
                        (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
            }else{
                return f.getClient().getIdClient();
            }
    }
}
