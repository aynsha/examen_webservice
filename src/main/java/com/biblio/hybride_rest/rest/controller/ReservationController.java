package com.biblio.hybride_rest.rest.controller;

import com.biblio.hybride_rest.rest.dto.ReservationRequest;
import com.biblio.hybride_rest.rest.model.Livre;
import com.biblio.hybride_rest.rest.model.Reservation;
import com.biblio.hybride_rest.rest.model.Utilisateur;
import com.biblio.hybride_rest.rest.repository.LivreRepository;
import com.biblio.hybride_rest.rest.repository.ReservationRepository;
import com.biblio.hybride_rest.rest.repository.UtilisateurRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationRepository reservationRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final LivreRepository livreRepository;

    public ReservationController(ReservationRepository reservationRepository,
                                 UtilisateurRepository utilisateurRepository,
                                 LivreRepository livreRepository) {
        this.reservationRepository = reservationRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.livreRepository = livreRepository;
    }

    // GET /reservations/{id} : suivi d'une réservation
    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation introuvable avec l'id : " + id));
    }

    @PostMapping
    public Reservation createReservation(@RequestBody ReservationRequest request) {
        Utilisateur utilisateur = utilisateurRepository.findById(request.getUtilisateurId())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        Livre livre = livreRepository.findById(request.getLivreId())
                .orElseThrow(() -> new RuntimeException("Livre non trouvé"));

        if (!"DISPONIBLE".equals(livre.getStatut())) {
            throw new RuntimeException("Le livre n'est pas disponible");
        }

        Reservation reservation = Reservation.builder()
                .utilisateur(utilisateur)
                .livre(livre)
                .dateDebut(request.getDateDebut())
                .dateFin(request.getDateFin())
                .statut("EN_COURS")
                .build();

        livre.setStatut("RESERVEE");
        livreRepository.save(livre);

        return reservationRepository.save(reservation);
    }
}
