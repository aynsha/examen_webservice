package com.biblio.hybride_rest.soap.endpoint;


import com.biblio.hybride_rest.rest.model.Livre;
import com.biblio.hybride_rest.rest.repository.LivreRepository;
import com.biblio.hybride_rest.soap.dto.*;
import com.biblio.hybride_rest.soap.dto.request.*;
import com.biblio.hybride_rest.soap.dto.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.*;

@Endpoint
public class LivreGestionEndpoint {

    private static final String NAMESPACE = "http://biblio.com/hybride_rest/soap";

    @Autowired
    private LivreRepository livreRepository;

    @PayloadRoot(namespace = NAMESPACE, localPart = "ajouterLivreRequest")
    @ResponsePayload
    public AjouterLivreResponse ajouterLivre(@RequestPayload AjouterLivreRequest request) {
        LivreDto dto = request.getLivre();
        System.out.println("Titre reçu : " + (dto != null ? dto.getTitre() : "DTO null"));

        if (dto == null) {
            throw new RuntimeException("Livre non fourni dans la requête SOAP");
        }
        Livre livre = new Livre();
        livre.setTitre(dto.getTitre());
        livre.setAuteur(dto.getAuteur());
        livre.setIsbn(dto.getIsbn());
        livre.setStatut(dto.getStatut());

        livreRepository.save(livre);

        AjouterLivreResponse response = new AjouterLivreResponse();
        response.setMessage("Livre ajouté avec succès !");
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "modifierLivreRequest")
    @ResponsePayload
    public ModifierLivreResponse modifierLivre(@RequestPayload ModifierLivreRequest request) {
        LivreDto dto = request.getLivre();
        ModifierLivreResponse response = new ModifierLivreResponse();

        if (dto == null || dto.getId() == null) {
            response.setMessage("Livre ou ID manquant dans la requête.");
            return response;
        }

        Livre livre = livreRepository.findById(dto.getId()).orElse(null);

        if (livre == null) {
            response.setMessage("Livre non trouvé.");
            return response;
        }

        livre.setTitre(dto.getTitre());
        livre.setAuteur(dto.getAuteur());
        livre.setIsbn(dto.getIsbn());
        livre.setStatut(dto.getStatut());
        livreRepository.save(livre);

        response.setMessage("Livre modifié avec succès.");
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE, localPart = "supprimerLivreRequest")
    @ResponsePayload
    public SupprimerLivreResponse supprimerLivre(@RequestPayload SupprimerLivreRequest request) {
        LivreDto dto = request.getLivre();

        SupprimerLivreResponse response = new SupprimerLivreResponse();

        if (dto == null || dto.getId() == null) {
            response.setMessage("ID du livre manquant pour la suppression.");
            return response;
        }

        livreRepository.deleteById(dto.getId());
        response.setMessage("Livre supprimé avec succès.");
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE, localPart = "preterLivreRequest")
    @ResponsePayload
    public PreterLivreResponse preterLivre(@RequestPayload PreterLivreRequest request) {
        LivreDto dto = request.getLivre();
        PreterLivreResponse response = new PreterLivreResponse();

        if (dto == null || dto.getId() == null) {
            response.setMessage("ID du livre manquant pour le prêt.");
            return response;
        }

        Livre livre = livreRepository.findById(dto.getId()).orElse(null);

        if (livre == null || !"DISPONIBLE".equalsIgnoreCase(livre.getStatut())) {
            response.setMessage("Livre non disponible pour le prêt.");
            return response;
        }

        livre.setStatut("PRETE");
        livreRepository.save(livre);
        response.setMessage("Livre prêté avec succès.");
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE, localPart = "retournerLivreRequest")
    @ResponsePayload
    public RetournerLivreResponse retournerLivre(@RequestPayload RetournerLivreRequest request) {
        LivreDto dto = request.getLivre();
        RetournerLivreResponse response = new RetournerLivreResponse();

        if (dto == null || dto.getId() == null) {
            response.setMessage("ID du livre manquant pour le retour.");
            return response;
        }

        Livre livre = livreRepository.findById(dto.getId()).orElse(null);

        if (livre == null || !"PRETE".equalsIgnoreCase(livre.getStatut())) {
            response.setMessage("Ce livre n’était pas en prêt.");
            return response;
        }

        livre.setStatut("DISPONIBLE");
        livreRepository.save(livre);
        response.setMessage("Livre retourné avec succès.");
        return response;
    }

}

