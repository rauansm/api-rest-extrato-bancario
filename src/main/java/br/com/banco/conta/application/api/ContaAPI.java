package br.com.banco.conta.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/conta")
public interface ContaAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ContaResponse criaConta (@Valid @RequestBody ContaRequest contaRequest);
}
