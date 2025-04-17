package com.biblio.hybride_rest.soap.dto.response;



import com.biblio.hybride_rest.rest.model.Livre;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@XmlRootElement(name = "GetLivreResponse")
public class GetLivreResponse {
    // Getters & setters
    private Livre livre;

}
