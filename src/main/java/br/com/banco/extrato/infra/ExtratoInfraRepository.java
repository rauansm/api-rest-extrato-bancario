package br.com.banco.extrato.infra;

import br.com.banco.extrato.application.repository.ExtratoRepository;
import br.com.banco.extrato.domain.ExtratoConta;
import br.com.banco.filtro.ExtratoFiltro;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ExtratoInfraRepository implements ExtratoRepository {
    private final ExtratoSpringDataJPA extratoSpringDataJPA;
    private final ExtratoJasperPDF extratoJasperPDF;
    @Override
    public List<ExtratoConta> extratoContaBancaria(Long idConta, ExtratoFiltro filtro) {
        log.info("[inicia] ExtratoInfraRepository - extratoContaBancaria");
        List<ExtratoConta> extrato = extratoSpringDataJPA.extratoContaBancaria(idConta,filtro);
        log.info("[finaliza] ExtratoInfraRepository - extratoContaBancaria");
        return extrato;
    }

    @Override
    public byte[] emitirExtratoBancarioPDF(Long idConta, BigDecimal saldoTotalConta, ExtratoFiltro filtro) throws JRException {
        log.info("[inicia] ExtratoInfraRepository - emitirExtratoBancarioPDF");
        byte[] vendasPDF = extratoJasperPDF.emitirExtratoBancarioPDF(idConta,saldoTotalConta,filtro);
        log.info("[finaliza] ExtratoInfraRepository - emitirExtratoBancarioPDF");
        return vendasPDF;
    }
}
