package br.com.banco.extrato.application.repository;

import br.com.banco.extrato.domain.ExtratoConta;
import br.com.banco.filtro.ExtratoFiltro;
import net.sf.jasperreports.engine.JRException;

import java.math.BigDecimal;
import java.util.List;

public interface ExtratoRepository {
    List<ExtratoConta> extratoContaBancaria(Long idConta, ExtratoFiltro filtro);

    byte[] emitirExtratoBancarioPDF(Long idConta, BigDecimal saldoTotalConta,  ExtratoFiltro filtro) throws JRException;
}
