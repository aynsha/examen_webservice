package com.biblio.hybride_rest.soap.dto.request;

import com.biblio.hybride_rest.soap.dto.LivreDto;
import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "ajouterLivreRequest", namespace = "http://biblio.com/hybride_rest/soap")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"livre"})
public class AjouterLivreRequest {

    @XmlElement(name = "livre",  required = true)
    private LivreDto livre;

    public LivreDto getLivre() { return livre; }

    public void setLivre(LivreDto livre) { this.livre = livre; }
}
