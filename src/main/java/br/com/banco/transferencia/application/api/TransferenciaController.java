package br.com.banco.transferencia.application.api;

import br.com.banco.filtro.TransacoesFiltro;
import br.com.banco.transferencia.application.service.TransferenciaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Override
    public List<TransferenciaResponse> pesquisaTransacoes(Long idConta, TransacoesFiltro filtro) {
        log.info("[inicia] TransferenciaController - pesquisaTransacoes");
        List<TransferenciaResponse> pesquisa = transferenciaService.pesquisaTransacoes(idConta, filtro);
        log.info("[finaliza] TransferenciaController - pesquisaTransacoes");
        return pesquisa;
    }
}
