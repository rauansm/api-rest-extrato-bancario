package br.com.banco.extrato.application.service;

import br.com.banco.extrato.domain.ExtratoConta;
import br.com.banco.filtro.ExtratoFiltro;
import net.sf.jasperreports.engine.JRException;

import java.util.List;

public interface ExtratoService {
    List<ExtratoConta> extratoContaBancaria(Long idConta, ExtratoFiltro filtro);

    byte[] gerarExtratoBancarioPDF(Long idConta, ExtratoFiltro filtro) throws JRException;
}
