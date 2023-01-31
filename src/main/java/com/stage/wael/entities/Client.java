package com.stage.wael.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idClient ;

    @NotNull
    private String nom;
    @NotNull
    private String prenom;

    @NotNull
    @Email
    private String email;


    @OneToMany(mappedBy ="client" ,cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    private Set<Facture> factures = new java.util.LinkedHashSet<>();

}
