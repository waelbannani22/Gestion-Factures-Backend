package com.stage.wael.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Facture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;

    private float montantFacture;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    // client a affecter
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idClient")
    private Client client;
    // fournisseur kifkif

    @ManyToOne
    @JsonIgnore
    private Fournisseur fournisseur;



}
