package com.stage.wael.services;

import com.stage.wael.entities.Fournisseur;

import java.util.List;

public interface IFournisseurService {

    Fournisseur addFournisseur(Fournisseur f);

    void deleteFournisseur (Long idF);

    Fournisseur updateFournisseur (Fournisseur f);

    List<Fournisseur> retrieveAllFournisseur();

    Fournisseur retrieveFournisseur(Long id);
}
