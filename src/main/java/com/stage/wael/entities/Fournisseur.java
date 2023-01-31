package com.stage.wael.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fournisseur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFournisseur;

    private String libelle;

    @Enumerated(EnumType.STRING)
    private CategorieFournisseur categourieFournisseur;

    //One fourn has to many factures

    @OneToMany(mappedBy="fournisseur",cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    private Set<Facture> factures;



}
