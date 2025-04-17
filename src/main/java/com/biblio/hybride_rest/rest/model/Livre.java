package com.biblio.hybride_rest.rest.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.*;

@Entity
@XmlRootElement(name = "livre") // Important pour la sérialisation SOAP
@XmlType(propOrder = {"titre", "auteur", "isbn", "statut"})
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String auteur;

    @Column(unique = true)
    private String isbn;

    private String statut; // DISPONIBLE, PRETE, RESERVEE



    // 🔧 Le constructeur complet
    public Livre(String titre, String auteur, String isbn, String statut) {
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
        this.statut = statut;
    }
}
