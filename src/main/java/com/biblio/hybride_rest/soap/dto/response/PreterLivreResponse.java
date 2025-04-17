package com.biblio.hybride_rest.soap.dto.response;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Setter;

@Setter
@XmlRootElement(name = "preterLivreResponse", namespace = "http://biblio.com/hybride_rest/soap")
@XmlType(propOrder = {"message"})
public class PreterLivreResponse {
    private String message;

    @XmlElement
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

