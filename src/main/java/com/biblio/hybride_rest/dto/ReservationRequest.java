package com.biblio.hybride_rest.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationRequest {
    private Long utilisateurId;
    private Long livreId;
    private LocalDate dateDebut;
    private LocalDate dateFin;
}
