package br.edu.infnet.tp03.service;

import br.edu.infnet.tp03.model.Cep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepTemplate {
    private final RestTemplate restTemplate;
    @Autowired
    public CepTemplate( RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity <Cep> buscaInfoCep( String cep ) {

        if (!cep.matches( "^\\d{8}$" )){
            return null;
        }

        String url_viacep= "https://viacep.com.br/ws/" + cep +"/json/";

        return restTemplate.getForEntity(url_viacep, Cep.class);

    }
}
