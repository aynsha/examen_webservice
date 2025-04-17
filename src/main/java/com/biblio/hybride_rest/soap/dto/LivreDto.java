package com.biblio.hybride_rest.soap.dto;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "livre", namespace = "http://biblio.com/hybride_rest/soap")

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "livre", propOrder = {"id", "titre", "auteur", "isbn", "statut"})
public class LivreDto {

    private Long id;

    @XmlElement(required = true)
    private String titre;

    @XmlElement(required = true)
    private String auteur;

    private String isbn;
    private String statut;

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
}
