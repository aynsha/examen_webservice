package com.biblio.hybride_rest.repository;

import com.biblio.hybride_rest.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
