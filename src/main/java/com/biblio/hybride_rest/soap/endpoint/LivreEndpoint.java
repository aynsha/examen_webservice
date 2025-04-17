package com.biblio.hybride_rest.soap.endpoint;

import com.biblio.hybride_rest.rest.model.Livre;
import com.biblio.hybride_rest.rest.repository.LivreRepository;
import com.biblio.hybride_rest.soap.dto.request.GetLivreRequest;
import com.biblio.hybride_rest.soap.dto.response.GetLivreResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LivreEndpoint {

    private static final String NAMESPACE_URI = "http://biblio.com/hybride_rest/soap";

    private final LivreRepository livreRepository;

    public LivreEndpoint(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetLivreRequest")
    @ResponsePayload
    public GetLivreResponse getLivre(@RequestPayload GetLivreRequest request) {
        Livre livre = livreRepository.findById(request.getId()).orElse(null);
        GetLivreResponse response = new GetLivreResponse();
        response.setLivre(livre);
        return response;
    }
}
