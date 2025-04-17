package com.biblio.hybride_rest.soap.dto.request;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetLivreRequest", namespace = "http://biblio.com/hybride_rest/soap")
@XmlType(name = "GetLivreRequest", propOrder = { "id" }, namespace = "http://biblio.com/hybride_rest/soap")
public class GetLivreRequest {

    private Long id;

    @XmlElement(namespace = "http://biblio.com/hybride_rest/soap")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

