package br.com.banco.transferencia.infra;

import br.com.banco.transferencia.application.repository.TransferenciaRepository;
import br.com.banco.transferencia.domain.Transferencia;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class TransferenciaInfraRepository implements TransferenciaRepository {

    private final TransferenciaSpringDataJPA transferenciaSpringDataJPA;
    @Override
    public Transferencia salva(Transferencia transferencia) {
        log.info("[inicia] TransferenciaInfraRepository - salva");
        transferenciaSpringDataJPA.save(transferencia);
        log.info("[finaliza] TransferenciaInfraRepository - salva");
        return transferencia;
    }
}
