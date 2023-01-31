package com.stage.wael.repositories;

import com.stage.wael.entities.Fournisseur;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends CrudRepository<Fournisseur,Long> {
    @Modifying
    @Query("update Fournisseur f set f.libelle=:nouvelleLibelle where f.idFournisseur=:id")
    public void updateFournisseur(@Param("id") Long id, @Param("nouvelleLibelle") String nouvelleLibelle);
}
