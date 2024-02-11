package br.com.banco.transferencia.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/transferencia")
public interface TransferenciaAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    TransferenciaResponse realizaTransacao (@Valid @RequestBody TransferenciaRequest transferenciaRequest);
}
