package br.com.banco.conta.infra;

import br.com.banco.conta.application.repository.ContaRepository;
import br.com.banco.conta.domain.Conta;
import br.com.banco.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ContaInfraRepository implements ContaRepository {
    private final ContaSpringDataJPA contaSpringDataJPA;
    @Override
    public Conta salva(Conta conta) {
        log.info("[inicia] ContaInfraRepository - salva");
        contaSpringDataJPA.save(conta);
        log.info("[finaliza] ContaInfraRepository - salva");
        return conta;
    }

    @Override
    public Conta buscaContaPeloId(Long idConta) {
        log.info("[inicia] ContaInfraRepository - buscaContaPeloId");
        Optional<Conta> conta = contaSpringDataJPA.findById(idConta);
        log.info("[finaliza] ContaInfraRepository - buscaContaPeloId");
        return conta.orElseThrow(() -> APIException.entidadeNaoEncontrada(String.format("Conta com id %s não encontrada.", idConta)));
    }
}
