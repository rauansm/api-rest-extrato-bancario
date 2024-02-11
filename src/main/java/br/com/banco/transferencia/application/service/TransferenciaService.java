package br.com.banco.transferencia.application.service;

import br.com.banco.filtro.TransacoesFiltro;
import br.com.banco.transferencia.application.api.TransferenciaRequest;
import br.com.banco.transferencia.application.api.TransferenciaResponse;

import java.util.List;

public interface TransferenciaService {
    TransferenciaResponse realizaTransacao(TransferenciaRequest transferenciaRequest);

    List<TransferenciaResponse> pesquisaTransacoes(Long idConta, TransacoesFiltro filtro);
}
