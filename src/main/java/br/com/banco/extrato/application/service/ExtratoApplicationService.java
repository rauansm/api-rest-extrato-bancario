package br.com.banco.extrato.application.service;

import br.com.banco.extrato.application.repository.ExtratoRepository;
import br.com.banco.extrato.domain.ExtratoConta;
import br.com.banco.filtro.ExtratoFiltro;
import br.com.banco.transferencia.application.service.TransferenciaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ExtratoApplicationService implements ExtratoService {
    private final ExtratoRepository extratoRepository;
    private final TransferenciaService transferenciaService;

    @Override
    public List<ExtratoConta> extratoContaBancaria(Long idConta, ExtratoFiltro filtro) {
        log.info("[inicia] ExtratoApplicationService - extratoContaBancaria");
        List<ExtratoConta> extrato = extratoRepository.extratoContaBancaria(idConta,filtro);
        log.info("[finaliza] ExtratoApplicationService - extratoContaBancaria");
        return extrato;
    }

    @Override
    public byte[] gerarExtratoBancarioPDF(Long idConta, ExtratoFiltro filtro) throws JRException {
        log.info("[inicia] ExtratoApplicationService - consultarVendasDiariasPDF");
        BigDecimal saldoTotalConta = transferenciaService.buscaSaldoTotalDaConta(idConta);
        byte[] vendasDiariasPDF = extratoRepository.emitirExtratoBancarioPDF(idConta,saldoTotalConta, filtro);
        log.info("[finaliza] ExtratoApplicationService - consultarVendasDiariasPDF");
        return vendasDiariasPDF;
    }
}
