package br.com.banco.conta.application.api;

import br.com.banco.conta.application.service.ContaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ContaController implements ContaAPI{
    private final ContaService contaService;

    @Override
    public ContaResponse criaConta(ContaRequest contaRequest) {
        log.info("[inicia] ContaController - criaConta");
        ContaResponse contaCriada = contaService.criaConta(contaRequest);
        log.info("[finaliza] ContaController - criaConta");
        return contaCriada;
    }

    @Override
    public ContaResponse buscaContaPeloId(Long idConta) {
        log.info("[inicia] ContaController - buscaContaPeloId");
        ContaResponse conta = contaService.buscaContaPeloId(idConta);
        log.info("[finaliza] ContaController - buscaContaPeloId");
        return conta;
    }
}
