package com.biblio.hybride_rest.repository;

import com.biblio.hybride_rest.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, Long> {
    List<Livre> findByStatut(String statut);
}