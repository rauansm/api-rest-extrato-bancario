package br.com.banco.transferencia.application.api;

import br.com.banco.filtro.TransacoesFiltro;
import br.com.banco.transferencia.application.service.TransferenciaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class TransferenciaController implements TransferenciaAPI {

    private final TransferenciaService transferenciaService;

    @Override
    public TransacaoResponse realizaTransacao(TransacaoRequest transacaoRequest) {
        log.info("[inicia] TransferenciaController - realizaTransacao");
        TransacaoResponse transacao = transferenciaService.realizaTransacao(transacaoRequest);
        log.info("[finaliza] TransferenciaController - realizaTransacao");
        return transacao;
    }

    @Override
    public Page<TransacaoResponse> pesquisaTransacoes(Long idConta, TransacoesFiltro filtro, Pageable pageable) {
        log.info("[inicia] TransferenciaController - pesquisaTransacoes");
        Page<TransacaoResponse> transacoes = transferenciaService.pesquisaTransacoes(idConta, filtro, pageable);
        log.info("[finaliza] TransferenciaController - pesquisaTransacoes");
        return transacoes;
    }
}
