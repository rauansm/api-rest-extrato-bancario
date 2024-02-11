package br.com.banco.conta.infra;

import br.com.banco.conta.application.repository.ContaRepository;
import br.com.banco.conta.domain.Conta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}
