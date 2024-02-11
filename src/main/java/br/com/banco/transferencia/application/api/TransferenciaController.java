package br.com.banco.transferencia.application.api;

import br.com.banco.transferencia.application.service.TransferenciaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class TransferenciaController implements TransferenciaAPI {

    private final TransferenciaService transferenciaService;

    @Override
    public TransferenciaResponse realizaTransacao(TransferenciaRequest transferenciaRequest) {
        log.info("[inicia] TransferenciaController - realizaTransacao");
        TransferenciaResponse transferencia = transferenciaService.realizaTransacao(transferenciaRequest);
        log.info("[finaliza] TransferenciaController - realizaTransacao");
        return transferencia;
    }
}