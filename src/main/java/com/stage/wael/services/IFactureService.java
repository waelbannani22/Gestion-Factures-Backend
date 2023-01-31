package com.stage.wael.services;

import com.stage.wael.entities.Facture;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IFactureService {
    List<Facture> retrieveAllFactures();

    Facture retrieveFacture(Long id);

    Facture cancelFacture(Long id);

    List<Facture> getFacturesByFournisseur(Long idF);

    List<Facture> getFacturesByClient(Long idC);

    void assignFactureToClientAndFournisseur(Long id,Long idFour,Long idC);

    Facture addFacture(Facture f,@NotNull Long idClient,@NotNull Long idFournisseur);

    Facture updateFacture(Facture f);

    Long getIdClientByFacture(Long idFacture);


}
