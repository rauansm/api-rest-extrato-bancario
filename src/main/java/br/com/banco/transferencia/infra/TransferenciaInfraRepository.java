package br.com.banco.transferencia.infra;

import br.com.banco.filtro.TransacoesFiltro;
import br.com.banco.transferencia.application.repository.TransferenciaRepository;
import br.com.banco.transferencia.domain.Transferencia;
import br.com.banco.transferencia.infra.spec.TransferenciaSpecs;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

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
    public Page<Transferencia> pesquisaTransacoes(Long idConta, TransacoesFiltro filtro, Pageable pageable) {
        log.info("[inicia] TransferenciaInfraRepository - pesquisaTransacoes");
        Page<Transferencia> transferencias = transferenciaSpringDataJPA.findAll(
                TransferenciaSpecs.usandoFiltro(idConta,filtro), pageable);
        log.info("[finaliza] TransferenciaInfraRepository - pesquisaTransacoes");
        return transferencias;
    }
    @Override
    public BigDecimal buscaSaldoTotalDaConta(Long idConta) {
        log.info("[inicia] TransferenciaInfraRepository - buscaSaldoTotalDaConta");
        BigDecimal saldoTotal = transferenciaSpringDataJPA.findbuscaSaldoTotalDaContaContaByIdConta(idConta);
        log.info("[finaliza] TransferenciaInfraRepository - buscaSaldoTotalDaConta");
        return saldoTotal;
    }
}
