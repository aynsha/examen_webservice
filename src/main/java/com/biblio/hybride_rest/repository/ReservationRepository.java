package com.biblio.hybride_rest.repository;

import com.biblio.hybride_rest.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
