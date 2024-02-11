package br.com.banco.conta.application.service;

import br.com.banco.conta.application.api.ContaRequest;
import br.com.banco.conta.application.api.ContaResponse;
import br.com.banco.conta.application.repository.ContaRepository;
import br.com.banco.conta.domain.Conta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ContaApplicationService implements ContaService{
    private final ContaRepository contaRepository;
    @Override
    public ContaResponse criaConta(ContaRequest contaRequest) {
        log.info("[inicia] ContaApplicationService - criaConta");
        Conta conta = contaRepository.salva(new Conta(contaRequest));
        log.info("[finaliza] ContaApplicationService - criaConta");
        return new ContaResponse(conta);
    }
}
