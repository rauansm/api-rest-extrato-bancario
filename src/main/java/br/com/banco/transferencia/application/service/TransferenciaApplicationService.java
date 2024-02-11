package br.com.banco.transferencia.application.service;

import br.com.banco.conta.application.repository.ContaRepository;
import br.com.banco.conta.domain.Conta;
import br.com.banco.transferencia.application.api.TransferenciaRequest;
import br.com.banco.transferencia.application.api.TransferenciaResponse;
import br.com.banco.transferencia.application.repository.TransferenciaRepository;
import br.com.banco.transferencia.domain.Transferencia;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
}