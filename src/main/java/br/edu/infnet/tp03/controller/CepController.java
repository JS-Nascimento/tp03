package br.edu.infnet.tp03.controller;

import br.edu.infnet.tp03.model.Cep;
import br.edu.infnet.tp03.service.CepTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RequestMapping(value = "/cep/")
@RestController
public class CepController {
    @Autowired
    private CepTemplate template;
    @GetMapping(value = "/{cep}")
    public ResponseEntity<Cep> getViaCep ( @PathVariable String cep ){

        ResponseEntity <Cep> result = template.buscaInfoCep( cep );

        if (result.getStatusCodeValue() == 200) {
            return ResponseEntity
                    .ok()
                    .body( result.getBody() )
                    ;
        }

        return ResponseEntity
                .badRequest()
                .body( result.getBody() ) ;

    }

}
