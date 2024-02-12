package br.com.banco.transferencia.application.service;

import br.com.banco.conta.application.repository.ContaRepository;
import br.com.banco.conta.domain.Conta;
import br.com.banco.filtro.TransacoesFiltro;
import br.com.banco.transferencia.application.api.TransferenciaRequest;
import br.com.banco.transferencia.application.api.TransferenciaResponse;
import br.com.banco.transferencia.application.repository.TransferenciaRepository;
import br.com.banco.transferencia.domain.Transferencia;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class TransferenciaApplicationService implements  TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;
    private final ContaRepository contaRepository;

    @Override
    public TransferenciaResponse realizaTransacao(TransferenciaRequest transferenciaRequest) {
        log.info("[inicia] TransferenciaApplicationService - realizaTransacao");
        Conta conta = contaRepository.buscaContaPeloId(transferenciaRequest.getIdConta());
        Transferencia transferencia = transferenciaRepository.salva(new Transferencia(transferenciaRequest, conta));
        log.info("[finaliza] TransferenciaApplicationService - realizaTransacao");
        return new TransferenciaResponse(transferencia);
    }

    @Override
    public Page<TransferenciaResponse> pesquisaTransacoes(Long idConta, TransacoesFiltro filtro, Pageable pageable) {
        log.info("[inicia] TransferenciaApplicationService - pesquisaTransacoes");
        Page<Transferencia> transacoes = transferenciaRepository.pesquisaTransacoes(idConta, filtro, pageable);
        List<TransferenciaResponse> transacoesListResponse = TransferenciaResponse.converte(transacoes);
        Page<TransferenciaResponse> transacoesPageResponse = new PageImpl<>(transacoesListResponse, pageable, transacoes.getTotalElements());
        log.info("[finaliza] TransferenciaApplicationService - pesquisaTransacoes");
        return transacoesPageResponse;
    }
}
