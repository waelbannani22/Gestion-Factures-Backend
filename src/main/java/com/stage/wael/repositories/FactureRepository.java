package com.stage.wael.repositories;

import com.stage.wael.entities.Facture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FactureRepository extends CrudRepository<Facture,Long> {
}
