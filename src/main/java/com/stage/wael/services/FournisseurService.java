package com.stage.wael.services;

import com.stage.wael.entities.Fournisseur;
import com.stage.wael.repositories.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@Transactional
public class FournisseurService implements IFournisseurService{

    @Autowired
    FournisseurRepository fournisseurRepo;


    @Override
    public Fournisseur addFournisseur(@NotNull Fournisseur f) {
        fournisseurRepo.save(f);
        return f;
    }

    @Override
    public void deleteFournisseur(Long idF) {
        fournisseurRepo.deleteById(idF);
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur f) {
        return fournisseurRepo.save(f);
    }


    @Override
    public List<Fournisseur> retrieveAllFournisseur() {
        return (List<Fournisseur>) fournisseurRepo.findAll();
    }

    @Override
    public Fournisseur retrieveFournisseur(Long id) {
        return (Fournisseur) fournisseurRepo.findById(id).orElse(null);
    }
}
