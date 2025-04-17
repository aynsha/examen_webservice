package com.biblio.hybride_rest.rest.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne
    private Livre livre;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String statut; // EN_COURS, CONFIRMEE, ANNULEE
}
