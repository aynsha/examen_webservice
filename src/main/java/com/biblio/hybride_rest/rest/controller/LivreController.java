package com.biblio.hybride_rest.rest.controller;

import com.biblio.hybride_rest.rest.model.Livre;
import com.biblio.hybride_rest.rest.repository.LivreRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livres")
public class LivreController {

    private final LivreRepository livreRepository;

    public LivreController(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    // GET /livres : récupérer tous les livres
    @GetMapping
    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    // GET /livres/{id} : récupérer un livre par ID
    @GetMapping("/{id}")
    public Livre getLivreById(@PathVariable Long id) {
        return livreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livre introuvable avec l'id : " + id));
    }

    // GET /livres/disponibles : récupérer les livres DISPONIBLES
    @GetMapping("/disponibles")
    public List<Livre> getLivresDisponibles() {
        return livreRepository.findByStatut("DISPONIBLE");
    }
}
