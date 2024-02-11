package br.com.banco.transferencia.infra;

import br.com.banco.filtro.TransacoesFiltro;
import br.com.banco.transferencia.application.repository.TransferenciaRepository;
import br.com.banco.transferencia.domain.Transferencia;
import br.com.banco.transferencia.infra.spec.TransferenciaSpecs;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<Transferencia> pesquisaTransacoes(Long idConta, TransacoesFiltro filtro) {
        log.info("[inicia] TransferenciaInfraRepository - pesquisaTransacoes");
        List<Transferencia> transferencias = transferenciaSpringDataJPA.findAll(
                TransferenciaSpecs.usandoFiltro(idConta,filtro));
        log.info("[finaliza] TransferenciaInfraRepository - pesquisaTransacoes");
        return transferencias;
    }
}
